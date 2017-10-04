/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robert;

/**
 *
 * @author Robert
 */
class Player {
    private String name;
    private Tag tag;
    void setName(String name) {
        this.name=name;
    }

    void setTag(Tag tag) {
        this.tag=tag;
    }

    @Override
    public String toString() {
        return name;
    }

    Tag getTag() {
        return tag;
    }
    
}
