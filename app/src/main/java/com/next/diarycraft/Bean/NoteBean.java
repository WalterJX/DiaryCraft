package com.next.diarycraft.Bean;

import com.baidu.mapapi.model.LatLng;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

////@Generated后面括号中的内容是系统自动生成的！
//the content after @Generated is generated by the system
@Entity //标注了Entity的类别要求每个对象具有“独一无二”的识别属性，并与主键相对应，使用@Id标注。
//@Entity means every instance of this class is unique and has a unique @id (corresponding to primary key)
public class NoteBean{
    @Id
    private Long id;
    private String noteinfo;
    private String notetype;
    private int date;
    private String time;
    private String photopath;
    private Boolean isshow;
    private String createtime;
    private double location_longtitude;
    private double location_latitude;
    private boolean hasLocation = false;
    private String people;
    private String labels;
    private String smallPicPath;

    @Generated(hash = 51407908)
    public NoteBean(Long id, String noteinfo, String notetype, int date, String time, String photopath, Boolean isshow,
            String createtime, double location_longtitude, double location_latitude, boolean hasLocation, String people,
            String labels, String smallPicPath) {
        this.id = id;
        this.noteinfo = noteinfo;
        this.notetype = notetype;
        this.date = date;
        this.time = time;
        this.photopath = photopath;
        this.isshow = isshow;
        this.createtime = createtime;
        this.location_longtitude = location_longtitude;
        this.location_latitude = location_latitude;
        this.hasLocation = hasLocation;
        this.people = people;
        this.labels = labels;
        this.smallPicPath = smallPicPath;
    }
    @Generated(hash = 451626881)
    public NoteBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNoteinfo() {
        return this.noteinfo;
    }
    public void setNoteinfo(String noteinfo) {
        this.noteinfo = noteinfo;
    }
    public String getNotetype() {
        return this.notetype;
    }
    public void setNotetype(String notetype) {
        this.notetype = notetype;
    }

    public String getTime() {
        return this.time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getPhotopath() {
        return this.photopath;
    }
    public void setPhotopath(String photopath) {
        this.photopath = photopath;
    }
    public Boolean getIsshow() {
        return this.isshow;
    }
    public void setIsshow(Boolean isshow) {
        this.isshow = isshow;
    }
    public String getCreatetime() {
        return this.createtime;
    }
    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }
    public void setLocation(LatLng loc){
        if (loc!=null) {
            this.location_latitude = loc.latitude;
            this.location_longtitude = loc.longitude;
        }
    }
    public LatLng getLocation() {return new LatLng(location_latitude, location_longtitude);}
    public double getLocation_longtitude() {
        return this.location_longtitude;
    }
    public void setLocation_longtitude(double location_longtitude) {
        this.location_longtitude = location_longtitude;
    }
    public double getLocation_latitude() {
        return this.location_latitude;
    }
    public void setLocation_latitude(double location_latitude) {
        this.location_latitude = location_latitude;
    }
    public boolean getHasLocation() {
        return this.hasLocation;
    }
    public void setHasLocation(boolean hasLocation) {
        this.hasLocation = hasLocation;
    }
    public String getPeople() {
        return this.people;
    }
    public void setPeople(String people) {
        this.people = people;
    }
    public int getDate() {
        return this.date;
    }
    public void setDate(int date) {
        this.date = date;
    }
    public String getLabels() {
        return this.labels;
    }
    public void setLabels(String labels) {
        this.labels = labels;
    }
    public String getSmallPicPath() {
        return this.smallPicPath;
    }
    public void setSmallPicPath(String smallPicPath) {
        this.smallPicPath = smallPicPath;
    }
}
