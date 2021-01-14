package common

sealed trait Val

case class IntV(i: Int) extends Val {
  implicit def IntToIntV() : Int = i
  implicit def IntVToInt() : IntV = IntV(i)
}
// case class BoolV(b: Boolean) extends Val