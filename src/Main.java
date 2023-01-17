import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Album album1 = new Album("Taylor","Taylor Swift");
        album1.addSong("Look what you made me do",4.16);
        album1.addSong("Love story", 3.55);
        album1.addSong("Willow", 4.13);

        Album album2 = new Album("Gaga","Lady Gaga");
        album2.addSong("Bloody Mary",4.04);
        album2.addSong("Poker Face", 3.57);
        album2.addSong("Just Dance", 4.13);

        System.out.println(album1.findSong("Just Dance"));

        LinkedList<Song> myPlayList = new LinkedList<>();
        album1.addToPlaylistFromAlbum("Look what you made me do",  myPlayList);
        album2.addToPlaylistFromAlbum(2,myPlayList);




    }
}