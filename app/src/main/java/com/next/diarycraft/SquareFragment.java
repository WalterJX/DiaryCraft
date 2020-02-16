package com.next.diarycraft;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.next.diarycraft.Bean.NoteBean;
import com.next.diarycraft.Model.NoteInfoModel;

import java.util.List;

//图墙fragment photowall fragment
public class SquareFragment extends Fragment {
    private Toolbar toolbar;
    private AppCompatActivity myActivity;
    private MyScrollView myScrollView;
    private NoteInfoModel noteInfoModel;
    public String[] ImagePaths;
    public List<NoteBean> list;

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_square, container, false);
        toolbar = (Toolbar) view.findViewById (R.id.toolbar_square);
        noteInfoModel=new NoteInfoModel(this.getActivity());
        refreshPicPaths();
        myScrollView = (MyScrollView) view.findViewById(R.id.my_scroll_view);
        myScrollView.setPresenter(this);
        return view;
    }

    public void onViewCreated(View view, @Nullable Bundle savedInstanceState){//toolbar初始化
        super.onViewCreated(view, savedInstanceState);
        myActivity = (AppCompatActivity) getActivity();
        toolbar.setTitle("Photo Wall");
        myActivity.setSupportActionBar(toolbar);
        toolbar.inflateMenu(R.menu.empty_menu);
    }

    @Override
    public void onResume() {
        super.onResume();
        refreshPicPaths();
    }

    public void refreshPicPaths(){
        //获取所有包含图片的notebean和其中所有的图片路径 // get all of the notebeans in the database that contains picture and the path of these pictures.
        list = noteInfoModel.readAllPhotoBean();
        ImagePaths = new String[list.size()];
        for(int i=0;i<list.size();i++){
            ImagePaths[i] = list.get(i).getPhotopath();
        }
    }
}
