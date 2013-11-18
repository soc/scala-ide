package migrateprocedure

class MigrateProcedure {
  trait Bar {
    def bar1
    def bar2
    {}
    def bar3
    ()
    {}
    def bar4NO
    ()
    : Unit
  }

  trait Foo {
    def foo1 {}
    def foo2NO: Unit
  }

  abstract class Baz {
    def baz1
    def baz2()
    def baz3(i: Int)
    def baz4NO(i: Int): Unit
    def baz5NO(i: Int): Unit = {}
  }
}
