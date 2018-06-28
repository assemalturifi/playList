package com.company;
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


import java.util.ArrayList;
import java.util.LinkedList;

public class PlayList {
    private ArrayList<Album>albums;
    private LinkedList<Song>playlist;

    public PlayList() {
        this.albums = new ArrayList<Album>();
        this.playlist = new LinkedList<Song>();
    }

    public ArrayList<Album> getAlbums() {
        return albums;
    }

    public LinkedList<Song> getPlaylist() {
        return playlist;
    }
    public void addAlbum(String albumName){
        Album foundAlbum=findAlbum(albumName);
        if(foundAlbum==null){
            this.albums.add(new Album(albumName));
        }
        else{
            System.out.println("Album "+foundAlbum.getName()+" is already on file!");
        }
    }
    private Album findAlbum(String albumName){
        for(int i=0;i<this.albums.size();i++){
            Album checkedAlbums=this.albums.get(i);
            if(checkedAlbums.getName().equals(albumName)){
                return checkedAlbums;
            }
        }
        return null;
    }
    public void addSong(String albumName, String songName){
        Album checkedAlbum=findAlbum(albumName);
        if(checkedAlbum!=null){
            Song checkedSong=findSong(albumName,songName);
            if(checkedSong!=null){
                playlist.add(checkedSong);

            }else{
                System.out.println("Song is not in the album!");
            }

        }else if(checkedAlbum==null){
            System.out.println("Album is not on the file!");
        }
    }
    private Song findSong(String albumName, String songName){
        Album checkedAlbum=findAlbum(albumName);
        if(checkedAlbum!=null){
            for(int i=0;i<checkedAlbum.getSongs().size();i++){
                Song checkedSongs=checkedAlbum.getSongs().get(i);
                if(checkedSongs.getTitle().equals(songName)){
                    return checkedSongs;
                }
            }
        }
        return null;
    }
    public void addSongToAlbum(String albumName,String songName,double duration){
        Album checkedAlbum=findAlbum(albumName);
        if(checkedAlbum!=null){
            Song checkedSong=findSong(albumName,songName);
            if(checkedSong==null){
                checkedAlbum.addSongs(songName,duration);
            }
            else{
                System.out.println("Song is already in album");
            }
            }
        else if(checkedAlbum==null){
            System.out.println("Album is not on file");
        }

    }
}
