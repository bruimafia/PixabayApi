package ru.bruimafia.rx.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Image {
    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("pageURL")
    @Expose
    private String pageURL;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("tags")
    @Expose
    private String tags;

    @SerializedName("previewURL")
    @Expose
    private String previewURL;

    @SerializedName("previewWidth")
    @Expose
    private int previewWidth;

    @SerializedName("previewHeight")
    @Expose
    private int previewHeight;

    @SerializedName("webformatURL")
    @Expose
    private String webformatURL;

    @SerializedName("webformatWidth")
    @Expose
    private int webformatWidth;

    @SerializedName("webformatHeight")
    @Expose
    private int webformatHeight;

    @SerializedName("largeImageURL")
    @Expose
    private String largeImageURL;

    @SerializedName("imageWidth")
    @Expose
    private int imageWidth;

    @SerializedName("imageHeight")
    @Expose
    private int imageHeight;

    @SerializedName("imageSize")
    @Expose
    private int imageSize;

    @SerializedName("views")
    @Expose
    private int views;

    @SerializedName("tegs")
    @Expose
    private List<String> tegs = null;

    @SerializedName("downloads")
    @Expose
    private int downloads;

    @SerializedName("favorites")
    @Expose
    private int favorites;

    @SerializedName("likes")
    @Expose
    private int likes;

    @SerializedName("comments")
    @Expose
    private int comments;

    @SerializedName("user_id")
    @Expose
    private int userId;

    @SerializedName("user")
    @Expose
    private String user;

    @SerializedName("userImageURL")
    @Expose
    private String userImageURL;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPageURL() {
        return pageURL;
    }

    public void setPageURL(String pageURL) {
        this.pageURL = pageURL;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getPreviewURL() {
        return previewURL;
    }

    public void setPreviewURL(String previewURL) {
        this.previewURL = previewURL;
    }

    public int getPreviewWidth() {
        return previewWidth;
    }

    public void setPreviewWidth(int previewWidth) {
        this.previewWidth = previewWidth;
    }

    public int getPreviewHeight() {
        return previewHeight;
    }

    public void setPreviewHeight(int previewHeight) {
        this.previewHeight = previewHeight;
    }

    public String getWebformatURL() {
        return webformatURL;
    }

    public void setWebformatURL(String webformatURL) {
        this.webformatURL = webformatURL;
    }

    public int getWebformatWidth() {
        return webformatWidth;
    }

    public void setWebformatWidth(int webformatWidth) {
        this.webformatWidth = webformatWidth;
    }

    public int getWebformatHeight() {
        return webformatHeight;
    }

    public void setWebformatHeight(int webformatHeight) {
        this.webformatHeight = webformatHeight;
    }

    public String getLargeImageURL() {
        return largeImageURL;
    }

    public void setLargeImageURL(String largeImageURL) {
        this.largeImageURL = largeImageURL;
    }

    public int getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(int imageWidth) {
        this.imageWidth = imageWidth;
    }

    public int getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(int imageHeight) {
        this.imageHeight = imageHeight;
    }

    public int getImageSize() {
        return imageSize;
    }

    public void setImageSize(int imageSize) {
        this.imageSize = imageSize;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public List<String> getTegs() {
        return tegs;
    }

    public void setTegs(List<String> tegs) {
        this.tegs = tegs;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserImageURL() {
        return userImageURL;
    }

    public void setUserImageURL(String userImageURL) {
        this.userImageURL = userImageURL;
    }
}
