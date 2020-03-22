package ru.stqa.ptf.addressbook;

import org.testng.annotations.Test;

public class GroupDeletionTests extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {
    goToGroupsPage();
    selectGroup();
    deleteSelectedGroups();
    returnToGroupsPage();
  }
}
