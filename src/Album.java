import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private List<Song> songList;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songList = new ArrayList<>();
    }


    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getArtist() {

        return artist;
    }

    public void setArtist(String artist) {

        this.artist = artist;
    }

    public List<Song> getSongs() {

        return songList;
    }

    public void setSongs(List<Song> songList) {

        this.songList = songList;
    }

    public  boolean findSong(String title){
        for(Song s:songList){
            if(s.getTitle().equals(title)) return true;
        }
        return false;
    }


    void addSong(String title, double duration){
        Song s = new Song(title,duration);
        if(findSong(s.getTitle())==true) {
            System.out.println("Song Already added");
        }else{
            songList.add(s);
            System.out.println("Song added");
        }

    }

    // Polymorphism

    public void addToPlaylistFromAlbum(String title, LinkedList<Song> playList){

        if(findSong(title)==true){
            for(Song song: songList){
                if(song.getTitle().equals(title)){
                    playList.add(song);
                    System.out.println("Song added to your playlist");
                    break;
                }
            }

        }else{
            System.out.println("Song is not present in the Album");
        }
    }

    public void addToPlaylistFromAlbum(int trackNo, LinkedList<Song> playList){

        int index = trackNo-1;
        if((index >=0 && index< songList.size())){
            playList.add(songList.get(index));
            System.out.println("Song added to your playlist");
        }else{
            System.out.println("Invalid track no");
        }
    }




}
