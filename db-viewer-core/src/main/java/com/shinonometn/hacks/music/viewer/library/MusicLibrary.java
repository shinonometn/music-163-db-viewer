package com.shinonometn.hacks.music.viewer.library;

import com.shinonometn.hacks.music.viewer.info.PlayList;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cattenlinger on 2018/2/20.
 */
public class MusicLibrary {

    private TrackManager trackManager;

    private final String dbPath;

    private final File libraryDataPath;

    public MusicLibrary(File dbFile, File dataPath){
        // Initialize database connection and operator
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl("jdbc:sqlite:" + dbFile.getAbsolutePath());
        dataSource.setDriverClassName("org.sqlite.JDBC");
        JdbcTemplate databaseOperator = new JdbcTemplate(dataSource);
        dbPath = dbFile.getAbsolutePath();

        // Initialize music library path
        libraryDataPath = dataPath;
        if(!libraryDataPath.isDirectory()) throw new IllegalStateException("Target is not a directory!");

        trackManager = new TrackManager(databaseOperator);
    }

    /**
     *
     * Get all local storage playlist
     *
     * @return
     */
    public List<PlayList> getPlaylists(){
        return new ArrayList<>();
    }

    public String getDbPath() {
        return dbPath;
    }

    public File getLibraryDataPath() {
        return libraryDataPath;
    }

    public TrackManager getTrackManager(){
        return this.trackManager;
    }
}
