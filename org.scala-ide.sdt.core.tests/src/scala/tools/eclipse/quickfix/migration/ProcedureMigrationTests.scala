package scala.tools.eclipse.quickfix.migration

import org.junit.Test
import org.junit.AfterClass
import scala.tools.eclipse.EclipseUserSimulator
import scala.tools.eclipse.quickfix.QuickFixesTests
import scala.tools.eclipse.SettingConverterUtil
import scala.tools.eclipse.ScalaPlugin
import scala.tools.eclipse.testsetup.TestProjectSetup

object ProcedureMigrationTests extends TestProjectSetup("quickfix") with QuickFixesTests {

  {
    val prefs = project.projectSpecificStorage
    prefs.setValue(SettingConverterUtil.USE_PROJECT_SETTINGS_PREFERENCE, true)
    prefs.setValue("Xfuture", "true")
    prefs.setValue("deprecation", "true")
    prefs.save()
  }

//  @AfterClass
//  def deleteTestProject() {
//    project.underlying.delete(true, null)
//  }
}

class ProcedureMigrationTests {
  import ProcedureMigrationTests._

  @Test def procedureMigrations(): Unit = {
    withQuickFixes("migrateprocedure/MigrateProcedure.scala")(
      "Convert procedure `bar1` to method",
      "Convert procedure `bar2` to method",
      "Convert procedure `bar3` to method",
      "Convert procedure `foo1` to method",
      "Convert procedure `baz1` to method",
      "Convert procedure `baz2` to method",
      "Convert procedure `baz3` to method"
    )
  }
}
