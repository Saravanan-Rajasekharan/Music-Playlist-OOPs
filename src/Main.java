import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


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
        album1.addToPlaylistFromAlbum("Love story",myPlayList);
        album2.addToPlaylistFromAlbum("Bloody Mary", myPlayList);

        Song s = new Song("abc", 5);

        play(myPlayList);

    }

    public static void play(LinkedList<Song> playList){

        ListIterator<Song> itr = playList.listIterator();
        Scanner input = new Scanner(System.in);

        boolean isForward = false;


        if(playList.size()>0){
            System.out.println("Currently playing: ");
            System.out.println(itr.next());
            isForward = true;

        }else{
            System.out.println("PlayList empty");
            return;
        }

        System.out.println("Enter your option");
        printMenu();

        boolean quit = false;
        while(!quit){
            int choice = input.nextInt();
            switch (choice){
                case 1:
                    if(isForward==false){
                        itr.next();
                        isForward =true;
                    }
                    if(itr.hasNext()){
                        System.out.println(itr.next());
                    }else{
                        System.out.println("Your playlist ended");
                        isForward = false;
                    }
                    break;
                case 2:
                    if(isForward==true){
                        itr.previous();
                        isForward = false;
                    }
                    if(itr.hasPrevious()){
                        System.out.println(itr.previous());
                    }else{
                        System.out.println("You are at the start");
                        isForward = true;
                    }
                    break;
                case 3:
                    if(isForward){
                        if(itr.hasPrevious()) {
                            System.out.println(itr.previous());
                            isForward = false;
                        }

                    }else{
                        if (itr.hasNext()) {
                            System.out.println(itr.next());
                            isForward =true;
                        }else{
                            System.out.println("Song not present");
                        }
                    }

                    break;
                case 4:
                    printMenu();
                    break;
                case 5:
                    break;
                case 6:
                    printSongs(playList);
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }

    }

    public static void printSongs(LinkedList<Song> playList){
        for(Song song : playList){
            System.out.println(song);
        }
        return;
    }
    public static void printMenu(){

        System.out.println("1 - Play next");
        System.out.println("2 - Play previous");
        System.out.println("3 - Repeat the current song");
        System.out.println("4 - Show menu");
        System.out.println("5 - Delete the current song");
        System.out.println("6 - print all the songs in playlist");
        System.out.println("7 - Exit");
    }
}