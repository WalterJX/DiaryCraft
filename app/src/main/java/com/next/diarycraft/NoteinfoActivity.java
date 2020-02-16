package com.next.diarycraft;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;
import me.gujun.android.taggroup.TagGroup;
import com.next.diarycraft.Bean.Means;
import com.next.diarycraft.Bean.Noteinfo;

public class NoteinfoActivity extends SwipeActivity{
    private TagGroup tagGroup_people;
    private TagGroup tagGroup_label;
    private TextView textView_noteinfo;
    private MyImageView imageview_noteinfo;
    private Toolbar toolbar;
    private TextView date;

    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noteinfo);
        initView();
        getintentExtra();
    }
    private void initView(){
        initToolbarSeting();
        initTaggroupView();
        initTextview();
        initImageview();
    }
    private void getintentExtra(){//show info
        Intent mintent=getIntent();
        Bundle bundle=mintent.getExtras();
        Noteinfo noteinfo= (Noteinfo) bundle.getSerializable("noteinfo");
        //prestenerImpNoteinfo.readDatatoNoteinfo(noteinfo);
        readDatatoNoteinfo(noteinfo);
    }
    private void initToolbarSeting(){//toolbard的设置 setup toolbar
        toolbar=(Toolbar)this.findViewById(R.id.toolbar_noteinfo);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    private void initTaggroupView(){//实例化TagGroup get  instance
        tagGroup_people=(TagGroup)this.findViewById(R.id.taggroup_noteinfo_people);
        tagGroup_label=(TagGroup)this.findViewById(R.id.taggroup_noteinfo_label);
    }
    private void initTextview(){//实例化TextView get  instance
        textView_noteinfo=(TextView)this.findViewById(R.id.text_noteinfo_item);
        date = (TextView)this.findViewById(R.id.noteinfo_date);
    }
    private void initImageview(){//实例化ImagView get imageview instance
        imageview_noteinfo=(MyImageView) this.findViewById(R.id.noteinfo_imageview);
    }

    public void readNoteinfotoNotetext(String noteinfo) {
        if (noteinfo.isEmpty()){
            textView_noteinfo.setText("");
        }else {
            textView_noteinfo.setText(noteinfo);
            toolbar.setTitle(Means.getNoteTitleOnNoteinfoActivity(noteinfo));
        }
    }

    public void readPhotopathtoNoteImageview(String photopath, String type) {
        if (photopath.equals("null")){
            //imageview_noteinfo.setImageResource(R.drawable.photo_travel);//如果没有图片则显示默认图片 show default picture
        }else {
            Glide.with(this).load(photopath).into(imageview_noteinfo);
        }
    }

    public void readPeopleTaggroup(List<String> tags_people) {
        if(!tags_people.get(0).equals(""))//如果有人物 if have people
            tagGroup_people.setTags(tags_people);
    }
    public void readLabelTaggroup(List<String> tags_label){
        if(!tags_label.get(0).equals(""))//如果有标签 if have tag
            tagGroup_label.setTags(tags_label);
    }
    public void readDate(int dateInt){
        String dateShow = (dateInt+"").substring(0,4)+"-"+(dateInt+"").substring(4,6)+"-"+(dateInt+"").substring(6,8);
        date.setText(dateShow);
    }

    public void readDatatoNoteinfo(Noteinfo noteinfo) {
        this.readNoteinfotoNotetext(noteinfo.getNoteinfo());//show the text message
        this.readPhotopathtoNoteImageview(noteinfo.getPhotopath(),noteinfo.getNotetype());//show the picture
        List<String> tags=new ArrayList<String>();
        List<String> tags_people=new ArrayList<>();
        List<String> tags_label=new ArrayList<>();
        String people_tmp;
        String label_tmp;

        //将人物的String用分号隔开存到list中
        //save people tag in string, separated by semicolons and save them in list.
        people_tmp = noteinfo.getPeople();
        String[] p_tmp = people_tmp.split(";");
        for(int i=0;i<p_tmp.length;i++)
            tags_people.add(p_tmp[i]);
        //label同上
        //label saving, same as above
        label_tmp = noteinfo.getLabels();
        String[] l_tmp = label_tmp.split(";");
        for(int i=0;i<l_tmp.length;i++)
            tags_label.add(l_tmp[i]);

        this.readPeopleTaggroup(tags_people);//将人物的tagGroup显示 // show people taggroup
        this.readLabelTaggroup(tags_label);//将标签的tagGroup显示 // show tag taggroup
        this.readDate(noteinfo.getDate());//日期显示 // show date
    }
}
