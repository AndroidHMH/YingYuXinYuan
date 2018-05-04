package com.jiyun.yingyuxinyuan.ui.modular.teacher.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.model.bean.TeacherHomePageBean;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by asus on 2018/5/4.
 */

public class WorkRecyclerAdapter extends RecyclerView.Adapter<WorkRecyclerAdapter.Holder> {
    public static final String TU_PIAN = "图片";
    public static final String SHI_PIN = "视频";
    public static final String YIN_PIN = "音频";
    private List<TeacherHomePageBean.DataBean.HomewoksBean> homewoks;
    private Context context;

    public WorkRecyclerAdapter(List<TeacherHomePageBean.DataBean.HomewoksBean> homewoks) {
        this.homewoks = homewoks;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        View inflate = LayoutInflater.from(context).inflate(R.layout.work_recycler_item, parent, false);
        Holder holder = new Holder(inflate);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final Holder holder, int position) {
        TeacherHomePageBean.DataBean.HomewoksBean homewoksBean = homewoks.get(position);
        Object photo = homewoksBean.getPhoto();
        //加载学生头像
        if (photo != null) {
            String photoUrl = (String) photo;
            Glide.with(context).load(photoUrl).asBitmap()
                    .placeholder(R.mipmap.user_head_portrait).error(R.mipmap.user_head_portrait)
                    .dontAnimate()
                    .into(new BitmapImageViewTarget(holder.workRecyclerItemTitleImg) {
                        @Override
                        protected void setResource(Bitmap resource) {
                            holder.workRecyclerItemTitleImg.setImageBitmap(resource);
                        }
                    });
        }
        holder.workRecyclerItemStudentName.setText(homewoksBean.getNickname());
        holder.workRecyclerItemTime.setText("上传时间");
        holder.workRecyclerItemFrom.setText(homewoksBean.getSource());
        holder.workRecyclerItemContent.setText(homewoksBean.getContent());
        String worksType = homewoksBean.getWorksType();
        if (YIN_PIN.equals(worksType)) {
            holder.workRecyclerItemAudioImg.setVisibility(View.GONE);
            holder.workRecyclerItemIntroImg.setVisibility(View.VISIBLE);
            holder.workRecyclerItemAudioGorpu.setVerticalGravity(View.VISIBLE);
            holder.workRecyclerItemVideoGorpu.setVerticalGravity(View.GONE);
        } else if (TU_PIAN.equals(worksType)) {
            holder.workRecyclerItemAudioImg.setVisibility(View.GONE);
            holder.workRecyclerItemIntroImg.setVisibility(View.VISIBLE);
            Glide.with(context).load(homewoksBean.getCoverImg()).placeholder(R.color.gray_prograss_bg)
                    .error(R.color.gray_prograss_bg).dontAnimate().into(holder.workRecyclerItemIntroImg);
            holder.workRecyclerItemAudioGorpu.setVerticalGravity(View.GONE);
            holder.workRecyclerItemVideoGorpu.setVerticalGravity(View.GONE);
        } else if (SHI_PIN.equals(worksType)) {
            holder.workRecyclerItemAudioImg.setVisibility(View.GONE);
            holder.workRecyclerItemIntroImg.setVisibility(View.VISIBLE);
            Object duration = homewoksBean.getDuration();
            if (duration != null) {
                holder.workRecyclerItemVideoTime.setText((String) duration);
            }
            Glide.with(context).load(homewoksBean.getCoverImg()).placeholder(R.color.gray_prograss_bg)
                    .error(R.color.gray_prograss_bg).dontAnimate().into(holder.workRecyclerItemIntroImg);
            holder.workRecyclerItemAudioGorpu.setVerticalGravity(View.GONE);
            holder.workRecyclerItemVideoGorpu.setVerticalGravity(View.VISIBLE);
        }

        Object answerDate = homewoksBean.getAnswerDate();
        if (answerDate != null) {
            holder.workRecyclerItemTeacherGroup.setVerticalGravity(View.VISIBLE);
            holder.homeMasterworkListitemTeacherGroupLine.setVisibility(View.VISIBLE);
            Object tRealname = homewoksBean.getTRealname();
            Object tIntro = homewoksBean.getTIntro();
            if (tRealname != null) {
                holder.workRecyclerItemTeacherName.setText((String) tRealname);
                if (tIntro != null) {
                    holder.workRecyclerItemTeacherIntro.setText((String) tIntro);
                }
            }
            if (homewoksBean.getIsPeep() == 0) {
                holder.workRecyclerItemPeepPrice.setText(String.format("%s元偷看", homewoksBean.getPeepPrice()));
            } else {
                holder.workRecyclerItemPeepPrice.setText("查看");
            }
        } else {
            holder.workRecyclerItemTeacherGroup.setVerticalGravity(View.GONE);
            holder.homeMasterworkListitemTeacherGroupLine.setVisibility(View.GONE);
        }

        if (homewoksBean.getCommentNum() != 0) {
            holder.workRecyclerItemReplyCb.setText(homewoksBean.getCommentNum() + "");
        } else {
            holder.workRecyclerItemReplyCb.setText("");
        }

        if (homewoksBean.getPraiseNum() != 0) {
            holder.workRecyclerItemPraiseCb.setText(homewoksBean.getPraiseNum() + "");
        } else {
            holder.workRecyclerItemPraiseCb.setText("");
        }

        if (homewoksBean.getIsPraise() == 0) {
            holder.workRecyclerItemPraiseCb.setChecked(false);
        } else {
            holder.workRecyclerItemPraiseCb.setChecked(true);
        }

        if (homewoksBean.getGiftNum() != 0) {
            holder.workRecyclerItemRewardCb.setText(homewoksBean.getGiftNum() + "");
        } else {
            holder.workRecyclerItemRewardCb.setText("");
        }

    }

    @Override
    public int getItemCount() {
        return homewoks.isEmpty() ? 0 : homewoks.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        @BindView(R.id.work_recycler_item_title_img)
        RoundedImageView workRecyclerItemTitleImg;
        @BindView(R.id.work_recycler_item_student_name)
        TextView workRecyclerItemStudentName;
        @BindView(R.id.work_recycler_item_time)
        TextView workRecyclerItemTime;
        @BindView(R.id.work_recycler_item_from)
        TextView workRecyclerItemFrom;
        @BindView(R.id.work_recycler_item_content)
        TextView workRecyclerItemContent;
        @BindView(R.id.work_recycler_item_content_intro)
        TextView workRecyclerItemContentIntro;
        @BindView(R.id.work_recycler_item_intro_img)
        ImageView workRecyclerItemIntroImg;
        @BindView(R.id.work_recycler_item_audio_img)
        ImageView workRecyclerItemAudioImg;
        @BindView(R.id.work_recycler_item_audio_time)
        TextView workRecyclerItemAudioTime;
        @BindView(R.id.work_recycler_item_audio_gorpu)
        RelativeLayout workRecyclerItemAudioGorpu;
        @BindView(R.id.work_recycler_item_video_time)
        TextView workRecyclerItemVideoTime;
        @BindView(R.id.work_recycler_item_video_gorpu)
        LinearLayout workRecyclerItemVideoGorpu;
        @BindView(R.id.work_recycler_item_intro_img_group)
        RelativeLayout workRecyclerItemIntroImgGroup;
        @BindView(R.id.work_recycler_item_work_type)
        TextView workRecyclerItemWorkType;
        @BindView(R.id.work_recycler_item_teacher_img)
        RoundedImageView workRecyclerItemTeacherImg;
        @BindView(R.id.work_recycler_item_teacher_name)
        TextView workRecyclerItemTeacherName;
        @BindView(R.id.work_recycler_item_teacher_intro)
        TextView workRecyclerItemTeacherIntro;
        @BindView(R.id.work_recycler_item_peep_price)
        TextView workRecyclerItemPeepPrice;
        @BindView(R.id.work_recycler_item_peep)
        LinearLayout workRecyclerItemPeep;
        @BindView(R.id.work_recycler_item_teacher_group)
        RelativeLayout workRecyclerItemTeacherGroup;
        @BindView(R.id.home_masterwork_listitem_teacher_group_line)
        TextView homeMasterworkListitemTeacherGroupLine;
        @BindView(R.id.work_recycler_item_reply_cb)
        CheckBox workRecyclerItemReplyCb;
        @BindView(R.id.work_recycler_item_reply_group)
        LinearLayout workRecyclerItemReplyGroup;
        @BindView(R.id.work_recycler_item_praise_cb)
        CheckBox workRecyclerItemPraiseCb;
        @BindView(R.id.work_recycler_item_praise_group)
        LinearLayout workRecyclerItemPraiseGroup;
        @BindView(R.id.work_recycler_item_reward_cb)
        CheckBox workRecyclerItemRewardCb;
        @BindView(R.id.work_recycler_item_reward_group)
        LinearLayout workRecyclerItemRewardGroup;
        @BindView(R.id.work_recycler_item_share)
        LinearLayout workRecyclerItemShare;

        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
