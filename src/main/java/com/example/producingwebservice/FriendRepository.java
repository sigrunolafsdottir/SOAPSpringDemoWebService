package com.example.producingwebservice;


import io.spring.guides.gs_producing_web_service.Friend;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component
public class FriendRepository {
    private static final Map<String, Friend> friends = new HashMap<>();

    @PostConstruct
    public void initData() {
        Friend mia = new Friend();
        mia.setName("Mia");
        mia.setAddress("Älta");
        mia.setId(1);
        mia.setMobile("12345");

        friends.put(mia.getName(), mia);

        Friend ingrid = new Friend();
        ingrid.setName("Ingrid");
        ingrid.setAddress("Bälinge");
        ingrid.setId(2);
        ingrid.setMobile("65432");

        friends.put(ingrid.getName(), ingrid);

        Friend susana = new Friend();
        susana.setName("Susana");
        susana.setAddress("Uppsala");
        susana.setId(3);
        susana.setMobile("98765");

        friends.put(susana.getName(), susana);
    }

    public Friend findFriend(String name) {
        Assert.notNull(name, "The friend's name must not be null");
        return friends.get(name);
    }
}