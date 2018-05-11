package com.jiyun.yingyuxinyuan.ui.modular.person.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.yingyuxinyuan.R;
import com.jiyun.yingyuxinyuan.base.BaseFragment;
import com.jiyun.yingyuxinyuan.config.LoginShareUtils;
import com.jiyun.yingyuxinyuan.ui.activity.LoginActivity;
import com.jiyun.yingyuxinyuan.ui.activity.ResginActivity;
import com.jiyun.yingyuxinyuan.ui.activity.my.chongzhi.activity.ChongCenterActivity;
import com.jiyun.yingyuxinyuan.ui.activity.my.dingdan.activity.DingDanActivity;
import com.jiyun.yingyuxinyuan.ui.activity.my.fensi.activity.FenSiActivity;
import com.jiyun.yingyuxinyuan.ui.activity.my.gift.activity.GiftActivity;
import com.jiyun.yingyuxinyuan.ui.activity.my.guanzhu.activity.GuanZhuActivity;
import com.jiyun.yingyuxinyuan.ui.activity.my.messagelis.activity.MessageActivity;
import com.jiyun.yingyuxinyuan.ui.activity.my.mymessage.activity.MySettingActivity;
import com.jiyun.yingyuxinyuan.ui.activity.my.myself.activity.MySelfActivity;
import com.jiyun.yingyuxinyuan.ui.activity.my.renzheng.activity.RenZhengActivity;
import com.jiyun.yingyuxinyuan.ui.activity.my.setting.activity.SettingActivity;
import com.jiyun.yingyuxinyuan.ui.activity.my.store.activity.StoreActivity;
import com.jiyun.yingyuxinyuan.ui.activity.my.tiezi.activity.TieZiActivity;
import com.jiyun.yingyuxinyuan.ui.activity.my.zuoping.activity.ZuoPingActivity;
import com.jiyun.yingyuxinyuan.ui.activity.resgin.activity.SetHobbyActivity;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.Unbinder;

import static android.content.Context.MODE_PRIVATE;

/**
 *
 */
public class LoginPersonFragment extends BaseFragment {

    @BindView(R.id.setting_my)
    ImageView settingMy;
    @BindView(R.id.message_my)
    ImageView messageMy;
    @BindView(R.id.image_tou)
    ImageView imageTou;
    @BindView(R.id.my_name)
    TextView myName;
    @BindView(R.id.mymessage_my)
    TextView mymessageMy;
    @BindView(R.id.zuoping)
    LinearLayout zuoping;
    @BindView(R.id.tiezi)
    LinearLayout tiezi;
    @BindView(R.id.guanzhu)
    LinearLayout guanzhu;
    @BindView(R.id.fensi)
    LinearLayout fensi;
    @BindView(R.id.fukuan_my)
    LinearLayout fukuanMy;
    @BindView(R.id.shiyong_my)
    LinearLayout shiyongMy;
    @BindView(R.id.tuihuo_my)
    LinearLayout tuihuoMy;
    @BindView(R.id.dingdan_my)
    LinearLayout dingdanMy;
    @BindView(R.id.chongzhi_my)
    LinearLayout chongzhiMy;
    @BindView(R.id.gife_my)
    LinearLayout gifeMy;
    @BindView(R.id.store_my)
    LinearLayout storeMy;
    @BindView(R.id.pianhao_my)
    LinearLayout pianhaoMy;
    @BindView(R.id.renzheng_myself)
    LinearLayout renzhengMyself;
    @BindView(R.id.linear_myself2)
    LinearLayout linearMyself2;
    @BindView(R.id.myself_setting)
    ImageView myselfSetting;
    @BindView(R.id.title_message_iv)
    ImageView titleMessageIv;
    @BindView(R.id.myself_resgin)
    Button myselfResgin;
    @BindView(R.id.myself_login)
    Button myselfLogin;
    @BindView(R.id.linear_myself1)
    LinearLayout linearMyself1;
    private SharedPreferences login;
    private Intent intent;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login_person;
    }

    @Override
    protected void init() {
        intent = new Intent(getActivity(), DingDanActivity.class);
    }

    @Override
    public void onResume() {
        super.onResume();
        login = getActivity().getSharedPreferences("Login", MODE_PRIVATE);
        String nickname = login.getString("nickname", null);
        if (null == nickname) {
            linearMyself1.setVisibility(View.VISIBLE);
            linearMyself2.setVisibility(View.GONE);
        } else {
            linearMyself1.setVisibility(View.GONE);
            linearMyself2.setVisibility(View.VISIBLE);
            setViews();
        }
    }

    private void setViews() {
        //加载头像
        Glide.with(getContext()).load(LoginShareUtils.getUserMessage(getContext(), LoginShareUtils.PHOTO)).placeholder(R.color.gray_prograss_bg)
                .error(R.color.gray_prograss_bg).dontAnimate().into(imageTou);
        //设置昵称
        myName.setText(LoginShareUtils.getUserMessage(getContext(), LoginShareUtils.NICKNAME));

    }

    @Override
    protected void loadDate() {

    }

    @OnClick({R.id.setting_my, R.id.message_my, R.id.image_tou, R.id.my_name, R.id.mymessage_my,
            R.id.zuoping, R.id.tiezi, R.id.guanzhu, R.id.fensi,
            R.id.fukuan_my, R.id.shiyong_my, R.id.tuihuo_my, R.id.dingdan_my,
            R.id.chongzhi_my, R.id.gife_my, R.id.store_my, R.id.pianhao_my, R.id.renzheng_myself,
            R.id.myself_setting, R.id.title_message_iv, R.id.myself_resgin, R.id.myself_login, R.id.linear_myself1
    })
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.linear_myself1:
                break;
            case R.id.myself_setting:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.title_message_iv:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
            case R.id.myself_resgin:
                startActivity(new Intent(getActivity(), ResginActivity.class));
                break;
            case R.id.myself_login:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
//            设置
            case R.id.setting_my:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
//             消息提醒
            case R.id.message_my:
                startActivity(new Intent(getActivity(), MessageActivity.class));
                break;
//                头像
            case R.id.image_tou:
                startActivity(new Intent(getActivity(), MySelfActivity.class));
                break;
//                网名
            case R.id.my_name:
                break;
//                我的信息
            case R.id.mymessage_my:
                startActivity(new Intent(getActivity(), MySettingActivity.class));
                break;
//                作品
            case R.id.zuoping:
                startActivity(new Intent(getActivity(), ZuoPingActivity.class));
                break;
//                帖子
            case R.id.tiezi:
                startActivity(new Intent(getActivity(), TieZiActivity.class));
                break;
//                关注
            case R.id.guanzhu:
                startActivity(new Intent(getActivity(), GuanZhuActivity.class));
                break;
//                粉丝
            case R.id.fensi:
                startActivity(new Intent(getActivity(), FenSiActivity.class));
                break;
//                待付款
            case R.id.fukuan_my:
                intent.putExtra("show", "0");
                startActivity(intent);
                break;
//                待使用
            case R.id.shiyong_my:
                intent.putExtra("show", "1");
                startActivity(intent);
                break;
//                待退货
            case R.id.tuihuo_my:
                intent.putExtra("show", "4");
                startActivity(intent);
                break;
//            我的订单
            case R.id.dingdan_my:
                intent.putExtra("show", "-1");
                startActivity(intent);
                break;
//                充值中心
            case R.id.chongzhi_my:
                startActivity(new Intent(getActivity(), ChongCenterActivity.class));
                break;
//                礼物中心
            case R.id.gife_my:
                startActivity(new Intent(getActivity(), GiftActivity.class));
                break;
//                我的收藏
            case R.id.store_my:
                startActivity(new Intent(getActivity(), StoreActivity.class));
                break;
//                我的偏好
            case R.id.pianhao_my:
                startActivity(new Intent(getActivity(), SetHobbyActivity.class));
                break;
//                我要认证
            case R.id.renzheng_myself:
                startActivity(new Intent(getActivity(), RenZhengActivity.class));
                break;
        }
    }

}
