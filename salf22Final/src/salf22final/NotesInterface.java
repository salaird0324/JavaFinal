/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salf22final;

/**
 *
 * @author Spencer Laird
 */

//Interface for mulitple types of notes that will all be using the save, load, and exit methods.

public interface NotesInterface {
    public void exit();
    public void save();
    public void load();
}
