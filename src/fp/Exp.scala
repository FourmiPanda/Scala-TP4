package object fp {

  import common.{Op1, Op2, Val}

  def eval(exp: Exp): Val = exp match {
    case IntLit(v) => v
    case AExp1(op, e1) => op.toVal(eval(e1))
    case AExp2(op, e1, e2) => op.toVal(eval(e1),eval(e2))
  }
  def toInfix(exp: Exp): String = exp match {
    case IntLit(v) => "" + v
    case AExp1(op, e1) => op.toInfix(toInfix(e1))
    case AExp2(op, e1, e2) => op.toInfix(toInfix(e1),toInfix(e2))
  }

  sealed trait Exp

  case class IntLit(v: Val) extends Exp

  case class AExp1(op: Op1[Val], e1: Exp) extends Exp

  case class AExp2(op: Op2[Val], e1: Exp, e2: Exp) extends Exp

}

