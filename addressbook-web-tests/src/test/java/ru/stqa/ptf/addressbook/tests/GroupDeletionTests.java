package ru.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    app.goToGroupsPage();
    app.selectGroup();
    app.deleteSelectedGroups();
    app.returnToGroupsPage();
  }
}
