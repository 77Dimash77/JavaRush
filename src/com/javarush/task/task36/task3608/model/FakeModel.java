package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
  private   ModelData modelData = new ModelData();
    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        User user1 = new User("A",1,1);
        User user2 = new User("B",2,1);
        List<User> userList = new ArrayList<>();
        userList.add(user1);
        userList.add(user2);
        modelData.setUsers(userList);

    }
    public void loadDeletedUsers() { throw  new UnsupportedOperationException();}

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }
    public void deleteUserById(long id){throw  new UnsupportedOperationException();}
    public void changeUserData(String name, long id, int level){
        throw new UnsupportedOperationException();
    }
}
