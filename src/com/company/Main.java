package com.company;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    // Create a program that implements a playlist for songs
    //create a song class having Title and Duration for a song
    //The program will have an Album class containing a list of songs.

    //The albums will be stored in an ArrayList
    //Songs from different albums can be added to the playlist and will apear in the list in the order
    //they are added

    //Once the songs have been added to the playlist, create a menu of options to:-
    //Quit, skip forward to the next song, skip backwards to a previous song. replay the current song.
    //List the songs in the playlist
    //A song must exist in an album before it can be added to the playlist (so you can only play songs that you own.)
    //Hint: to replay a song, consider what happened when we went back and forth from a city before we
    //started tracking the direction we ere going.
    //As an optional extra, provide an option to remove the current song from the playlist
    //(hint: listiteerator.remove())


    public static void main(String[] args) {
	    PlayList playList=new PlayList();


        playList.addAlbum("blackAlbum");
        playList.addSongToAlbum("blackAlbum", "enterSandman", 2.30);
        playList.addAlbum("reloaded");
        playList.addSongToAlbum("reloaded", "unforgiven2", 3.30);
        playList.addAlbum("useYourIllusion");
        playList.addSongToAlbum("useYourIllusion", "nighTrain", 2.45);
        playList.addAlbum("useYourIllusion2");
        playList.addSongToAlbum("useYourIllusion2", "mrBrownStone", 2.10);
        playList.addSongToAlbum("useYourIllusion2", "youCouldBeMine", 2.20);
        playList.addSong("useYourIllusion2", "mrBrownStone");
        playList.addSong("useYourIllusion2", "youCouldBeMine");
        playList.addSong("reloaded", "unforgiven2");
        playList.addSong("blackAlbum", "enterSandman");
        playList.addSong("blackAlbum", "enterSandman");

        menu(playList);


    }
    public static void menu(PlayList playList){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        LinkedList<Song> songsInPlaylist = playList.getPlaylist();
        ListIterator<Song> listIterator = songsInPlaylist.listIterator();

        if (songsInPlaylist.isEmpty()) {
            System.out.println("No songs in Playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().getTitle());
            printOptions();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Closing playlist");
                    quit = true;
                    break;

                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Skipping to next song " + listIterator.next().getTitle());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing previous song " + listIterator.previous().getTitle());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        goingForward = true;
                    }
                    break;

                case 3:
                    if (goingForward) {
                        System.out.println("now playing " + listIterator.previous().getTitle());
                        goingForward = false;
                    } else {
                        System.out.println("now playing " +listIterator.next().getTitle());
                        goingForward = true;
                    }
                    break;

                case 4:
                    printOptions();
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public static void printOptions() {
        System.out.println("Available actions:\npress any of the actions below: ");
        System.out.println("0 - to quit\n" +
                "1 - skip forward to next song\n" +
                "2 - play previous song\n" +
                "3 - repeat song\n" +
                "4 - print menu options");
    }
}
