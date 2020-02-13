package com.next.diarycraft.Presenter;


import com.next.diarycraft.Bean.NoteBean;
import com.next.diarycraft.EditActivity;
import com.next.diarycraft.Model.NoteInfoModel;

//作为EditActivity连接数据库的中间类
// this is the class between EditActivity and database.
public class Prestener_edit {
    private EditActivity editActivity;
    private NoteInfoModel noteInfoModel;

    public Prestener_edit(EditActivity editActivityImp){//初始化 // initialization
        this.editActivity=editActivityImp;
        this.noteInfoModel=new NoteInfoModel(editActivityImp.getbasecontext());
    }

    //添加到数据库
    public void saveNoteinfotoDatabase(NoteBean noteBean) {
        if (noteBean.getId()!=null){
            noteInfoModel.ChangeNotetoData(noteBean);
        }else {
            noteInfoModel.InsertNotetoData(noteBean);
        }
    }
}
