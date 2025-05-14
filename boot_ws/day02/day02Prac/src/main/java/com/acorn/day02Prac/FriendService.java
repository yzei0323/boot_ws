package com.acorn.day02Prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendService {

    @Autowired
    FriendRepository repository;

    //친구조회
    public List<Friend> getFriends(){
        return repository.selectAll();
    }

    //친구추가
    public int addFriend(Friend friend){
        return repository.insert(friend);
    }

    //친구정보변경
    public int modifyFriend(Friend friend){
        return repository.update(friend);
    }

}
