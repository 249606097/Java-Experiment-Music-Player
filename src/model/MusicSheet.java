package model;

import db.DataBase;
import util.MD5Utils;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class MusicSheet {
    private String creator;
    private String creatorId;
    private String dateCreated;
    private int id;
    private String name;
    private String picture;
    private String uuid;

    private ArrayList<Music> musicArray = new ArrayList<>();

//    public MusicSheet(String id, String name, Date date, String owner, String picture) {
//        this.id = Integer.parseInt(id);
//        this.name = name;
//        this.date = date;
//        this.owner = owner;
//        this.picture = picture;
    public void test() {
        System.out.println(this.musicArray.get(0).getName());
    }
//    }
    public MusicSheet() {}

    /**
     * 创建歌单时使用
     * @param name
     * @param creator
     * @param creatorId
     * @param picture
     */
    public MusicSheet(String name, String creator, String creatorId, String picture) {
        this.name = name;
        this.creator = creator;
        this.creatorId = creatorId;
        this.picture = picture;

        this.dateCreated = (new Date()).toString();
        this.uuid = MD5Utils.MD5Encode(Integer.toString(this.id), "utf-8");
    }

    public MusicSheet(String id, String name, String date, String creator, String picture) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.dateCreated = date;
        this.creator = creator;
        this.picture = picture;
    }

    /**
     * 获取所有的歌单
     * @return [sheet, ...]
     */
    public static ArrayList<MusicSheet> getSheets() {
        ArrayList<MusicSheet> result = new ArrayList<>();

        ArrayList<HashMap<String, String>> array = DataBase.getAllSheets();
        for (HashMap<String, String> map: array) {
            result.add(new MusicSheet(map.get("id"), map.get("name"),
                    map.get("date"), map.get("owner"), map.get("picture")));
        }

        return result;
    }

    /**
     * 获取当前歌单的所有歌曲
     * @return [music, ...]
     */
    public ArrayList<Music> getMusicInThisSheet() {
        return DataBase.getMusicOfTheSheet(Integer.toString(this.id));
    }

    /**
     * 保存当前歌单到数据库
     */
    public void saveMusicSheet() {
        DataBase.createMusicSheet(this);
    }

    /**
     * 删除当前歌单中指定索引的歌曲
     * @param index
     */
    public void deleteMusic(int index) {
        Music deletedMusic = this.musicArray.remove(index);
    }

    public void addMusic(File file) {
        DataBase.addMusic(Integer.toString(this.id), file);
    }

    public ArrayList<Music> getMusicArray() {
        return musicArray;
    }

    public void setMusicArray(ArrayList<Music> musicArray) {
        this.musicArray = musicArray;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public void addToArray(Music music) {
        this.musicArray.add(music);
    }

    public static void main(String[] args) {
        System.out.println(new Date().toString());
    }
}
