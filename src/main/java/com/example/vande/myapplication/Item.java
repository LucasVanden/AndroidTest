package com.example.vande.myapplication;

import java.util.ArrayList;

public class Item {
    private String nName;
    private boolean mOnline;

    public Item(String nName,boolean b) {
        this.nName = nName;
        this.mOnline=b;
    }

    public String getnName() {
        return nName;
    }

    public boolean ismOnline() {
        return mOnline;
    }
    private static int lastContactId = 0;

    public static ArrayList<Item> createContactsList(int numContacts,String selecto) {
        ArrayList<Item> contacts = new ArrayList<Item>();

        for (int i = 1; i <= numContacts; i++) {
            contacts.add(new Item(selecto + ++lastContactId, i <= numContacts / 2));

        }

        return contacts;
    }


}
