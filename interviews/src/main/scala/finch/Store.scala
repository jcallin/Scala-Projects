package finch

import scala.collection.mutable

//Interface -
//new Store()
//store.begin() - begin a transaction (transactions can be nested)
//store.commit() - save all the current transactions (no transactions will be remaining)
//store.rollback() - rollback the currently active transaction and discard it
//store.set(key, value) - must be in an open transaction to set a key
//store.get(key) - do not have to be in an open transaction to get a value
//store.del(key) - must be in an open transaction to delete a key

//Example -
//> store = new Store()
//> store.begin()
//> store.set('x', 5)
//> store.set('y', 23)
//> store.get('x')
//X = 5
//> store.begin()
//> store.get('y')
//Y = 23
//> store.set('y', 42)

//> store.commit()
//> store.get('y')
//Y = 42
//> store.set('z', 1)

//'NO ACTIVE TRANSACTIONS'

//> store.begin()
//> store.set('x', 99)
//> store.rollback()
//> store.get('x')
//X = 5
//> store.end()

class Store {

  sealed trait Transaction
  case class Set(k: String, v: Int) extends Transaction
  case class Del(k: String)         extends Transaction

  type Transactions = mutable.ArrayBuffer[Transaction]

  val kvStore = mutable.Map[String, Int]()

  var transactions        = mutable.Stack[Transactions]()
  val pendingTransactions = mutable.ArrayBuffer.empty[Transaction]

  def begin(): Unit = {
    if (pendingTransactions.nonEmpty) {
      transactions.push(pendingTransactions)
      pendingTransactions.clear()
    }
  }

  def commit(): Unit = {
    transactions.map { ts =>
      ts.map {
        case Set(k, v) => kvStore.addOne((k, v))
        case Del(k)    => kvStore.remove(k)
      }
    }
    transactions.popAll()
  }

  def rollback(): Unit = {
    transactions.pop()
  }

  def set(k: String, v: Int): Unit = {
    // Check transaction stuff
    pendingTransactions.appendAll(Iterable(Set(k, v)))
  }

  def get(k: String): Option[Int] = {
    pendingTransactions.reverse.map {
      case d: Del if d.k == k => return None
      case s: Set if s.k == k => return Some(s.v)
    }
    transactions.map { t =>
      t.reverse.map {
        case d: Del if d.k == k => return None
        case s: Set if s.k == k => return Some(s.v)
      }
    }
    kvStore.get(k)
  }

  def del(k: String): Unit = {
    pendingTransactions.appendAll(Iterable(Del(k)))
  }

}
