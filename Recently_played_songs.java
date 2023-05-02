package TestVagrant_Coding_Assignment;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
public class Recently_played_songs 
{
	private int capacity;
	   private Map<String, LinkedList<String>> songsByUser;
	  
	   public Recently_played_songs(int capacity) 
	   {
	       this.capacity = capacity;
	       songsByUser = new HashMap<>();
	   }
	  
	   public void addSong(String user, String song) 
	   {
	       if (!songsByUser.containsKey(user)) 
	       {
	           songsByUser.put(user, new LinkedList<>());
	       }
	       LinkedList<String> songs = songsByUser.get(user);
	       songs.add(song);
	       if (songs.size() > capacity)
	       {
	           songs.removeFirst();
	       }
	   }
	  
	   public List<String> getRecentlyPlayedSongs(String user) 
	   {
	       if (!songsByUser.containsKey(user)) 
	       {
	           return Collections.emptyList();
	       }
	       return songsByUser.get(user);
	   }
	   public static void main(String[] args) 
	   {
		   Recently_played_songs store = new Recently_played_songs(3);
	      
	       // PlayList would Like to
	       store.addSong("S", "1");
	       store.addSong("S", "2");
	       store.addSong("S", "3");
	      
	       System.out.println("Recently played songs for user S: " + store.getRecentlyPlayedSongs("S"));
	      
	       // User S4 plays some songs
	       store.addSong("S", "2");
	       store.addSong("S", "3");
	       store.addSong("S", "4");
	       System.out.println("Recently played songs for user S4: " + store.getRecentlyPlayedSongs("S"));
	      
	       // User S2 plays more songs
	       store.addSong("S", "3");
	       store.addSong("S", "4");
	       store.addSong("S", "2");
	       System.out.println("Recently played songs for user S2: " + store.getRecentlyPlayedSongs("S"));
	      
	       // User S1 plays more songs
	       store.addSong("S", "4");
	       store.addSong("S", "2");
	       store.addSong("S", "1");
	       System.out.println("Recently played songs for user S1: " + store.getRecentlyPlayedSongs("S"));
	   }
	}


