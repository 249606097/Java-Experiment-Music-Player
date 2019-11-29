//package model;
//
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
//import org.apache.commons.codec.digest.DigestUtils;
//
//import javax.swing.*;
//import java.io.*;
//import java.net.MalformedURLException;
//
//public class Music {
//    private File file = null;
//    private String MD5;
//    private String path;
//
//    private String sheetID;
//    private String sheetName;
//
//    // 前端显示 music的
//    //         歌名  歌手  专辑  时长
//    private String title;
//    private String singer;
//    private String album;
//    private double duration = 0.0;
//
////    private Image image; // 待定 TODO
//
//    public Music(String sheetID, String path) {
//        this.file = new File(path);
//        this.MD5 = this.generateMD5();
//        this.path = path;
//
//        this.sheetID = sheetID;
//        // TODO
////        this.sheetName = DataBase.getSheetName(sheetID);
//
//        try {
//            Media media = new Media(this.file.toURI().toURL().toExternalForm());
//            MediaPlayer mediaPlayer = new MediaPlayer(media);
//
//            mediaPlayer.setOnReady(new Runnable() {
//                @Override
//                public void run() {
//                    title = (String) media.getMetadata().get("title");
//                    singer = (String) media.getMetadata().get("artist");
//                    album = (String) media.getMetadata().get("album");
//                    duration = media.getDuration().toSeconds();
//
////                    image = (Image) media.getMetadata().get("image");  // 待定 TODO
////                    for (String str: media.getMetadata().keySet()) {
////                        System.out.println(str);
////                    }
//
//                }
//            });
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public String getTitle() {
//        return this.title;
//    }
//
//    public String getSinger() {
//        return this.singer;
//    }
//
//    public double getDuration() {
//        return this.duration;
//    }
//
//    public String getAlbum() {
//        return this.album;
//    }
//
//    public String getSheetName() {
//        return this.sheetName;
//    }
//
//    public String getMD5() {
//        return this.MD5;
//    }
//
//    public String getPath() {
//        return this.path;
//    }
//
//    /**
//     * 生成歌曲的 MD5
//     * @return MD5
//     */
//    private String generateMD5() {
//        String str = null;
//        try {
//            str = DigestUtils.md5Hex(new FileInputStream(this.file));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return str;
//    }
//
//
////    public static void main(String[] args) throws InterruptedException {
////        com.sun.javafx.application.PlatformImpl.startup(()->{});
////        Music music = new Music("w", "1", "华语群星-爸爸去哪儿.mp3");
////
////        System.out.println(music.getMD5());
////        JFrame frame = new JFrame(music.getSinger());
////        frame.setSize(200, 200);
////        frame.setLocationRelativeTo(null);
////        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
////
////        JButton button = new JButton(music.getSinger());
////        JPanel panel = new JPanel();
////
////        panel.add(button);
////
////        frame.setContentPane(panel);
////        frame.setVisible(true);
////    }
//
//}