package dev.lpa;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    /**
     * Add songs to the album's SongList. Returns true if the song was
     * successfully added to the SongList; otherwise, returns false.
     * @param title: String
     * @param duration: double
     * @return boolean
     */
    public boolean addSong(String title, double duration){
        /*
        * Check if the song is already in the SongList
        * Can either be songs.contains() to find the exact song object, or
        * could use findSong() with the title...
        * */
        Song songToAdd = new Song(title, duration);
        return songs.add(songToAdd);
    }

    /**
     * Add a song from the album to a separate playlist of type SongList.
     * Need to ensure the track number provides is actually available on the
     * album's list of songs. Return true if the song is successfully added to the
     * playlist; otherwise, return false.
     * @param trackNumber: int, the number of the track on the album's SongList
     * @param playList: LinkedList<Song>, the user's current Playlist
     * @return boolean
     */
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playList){
        /*
        * Check the album SongList for the provided trackNumber
        * If the song is returned, then add it to songs and return true.
        * If the song is not on the album, return false.
        * */
        Song songOnAlbum = songs.findSong(trackNumber);
        if(songOnAlbum != null){
            playList.add(songOnAlbum);
            return true;
        }
        return false;
    }

    /**
     * Add a song from the album to a separate playlist of type SongList.
     * The song with the same title needs to be available on the album's
     * list of songs. Return true if the song is successfully added
     * to the playlist; otherwise, return false;
     * @param title: String, title of the song to add from the album
     * @param playList: LinkedList<Song>, the user's current Playlist
     * @return boolean
     */
    public boolean addToPlayList(String title, LinkedList<Song> playList){
        /*
         * Check the album SongList for the provided title
         * If the song is returned, then add it to songs and return true.
         * If the song is not on the album, return false.
         * */
        Song songOnAlbum = songs.findSong(title);
        if(songOnAlbum != null){
            playList.add(songOnAlbum);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return """
                "%s"
                Artist: %s
                
                Track List
                %10s
                """.formatted(name, artist, songs);
    }

    public static class SongList{
        private List<Song> songs;

        public SongList(){
            this.songs = new ArrayList<>();
        }

        /**
         * Determine if the provided song is already in the songs ArrayList.
         * Call findSong with the provided song's title.
         * If the song is not found within songs, add it and return true.
         * If the song is found in songs, return false.
         * @param song: Song
         * @return boolean
         */
        public boolean add(Song song){

            // If the song was found in the list, return false.
            // Song cannot be added.
            if(findSong(song.getTitle()) != null){
                return false;
            }
            // Add the song to the list
            songs.add(song);
            return true;
        }

        /**
         * Search the existing list of songs for the given title.
         * @param title: String
         * @return Song or null
         */
        public Song findSong(String title){
            for(Song song : songs){
                if(song.getTitle().equalsIgnoreCase(title)){
                    return song;
                }
            }
            return null;
        }

        /**
         * Overloaded method that accepts a track number for a song.
         * If a song is found with that track number, the song is
         * returned. Otherwise, return null.
         * @param trackNum: int
         * @return Song | null
         */
        public Song findSong(int trackNum){
            return ((trackNum < 1 || trackNum > songs.size()) ? null : songs.get(trackNum-1));
        }

        @Override
        public String toString(){
            StringBuilder allSongs = new StringBuilder();
            for(Song song : songs){
                allSongs.append("\n");
                allSongs.append(song.toString());
            }
            return allSongs.toString();
        }
    }
}
