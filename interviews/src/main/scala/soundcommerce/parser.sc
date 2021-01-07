// ((1 + 2) * ((5 * 2) + 1))

sealed trait Expr
case class IntComponent(n: Int) extends Expr

trait Op                         extends Expr
case class Mul(a: Expr, b: Expr) extends Op
case class Add(a: Expr, b: Expr) extends Op

val startParens = '('
val endParens   = ')'

def parser(stringExpr: String): (Expr, String) = {
  if (!stringExpr.contains(startParens) && !stringExpr.contains(endParens)) {
    (IntComponent(stringExpr.toInt), "")
  } else {
    val modified = stringExpr.drop(1).dropRight(1)
    parser(modified) match {
      case (expr, str) =>
        str match {
          case s if s.startsWith("*") => Mul(expr, parser(s.drop(1)))
          case s if s.startsWith("+") => Add(expr, parser(s.drop(1)))
        }
    }
    modified match {
      case parser(left) + "*" + right => Mul(parser(left)
      case left + "+" + right =>
    }

  }
}

def evaluator(expression: Expr): Int = {
  expression match {
    case IntComponent(i) => i
    case Mul(a, b)       => evaluator(a) * evaluator(b)
    case Add(a, b)       => evaluator(a) + evaluator(b)
  }

}

def run(stringExpr: String): Int = {
  evaluator(parser(stringExpr))
}
