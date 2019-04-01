package dev147.com.vn.projectpsychological.ui.home;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;
import dev147.com.vn.projectpsychological.R;
import dev147.com.vn.projectpsychological.databinding.FramgmentHomeBinding;
import dev147.com.vn.projectpsychological.ui.base.BaseFragment;
import dev147.com.vn.projectpsychological.ui.custom.ViewPagerCustom;
import dev147.com.vn.projectpsychological.ui.test.TestActivity;
import dev147.com.vn.projectpsychological.utils.DataUtils;
import dev147.com.vn.projectpsychological.utils.Define;
import dev147.com.vn.projectpsychological.utils.Fields;
import dev147.com.vn.projectpsychological.utils.Utils;

public class HomeFragment extends BaseFragment<HomeViewModel, FramgmentHomeBinding> {
    private ViewPagerCustom mPager;

    @Override
    public Class<HomeViewModel> getModelClass() {
        return HomeViewModel.class;
    }

    @Override
    public int getLayoutId() {
        return R.layout.framgment_home;
    }

    @Override
    protected void initListenerOnClick() {
        binding.ivNeo.setOnClickListener(this);
        binding.layoutNeo.setOnClickListener(this);
        binding.ivRiasec.setOnClickListener(this);
        binding.layoutRiasec.setOnClickListener(this);
        binding.ivPsy.setOnClickListener(this);
        binding.layoutPsy.setOnClickListener(this);
    }

    @Override
    protected void initObserve() {

    }

    @Override
    protected void initView() {
    }

    @Override
    protected void initData() {
        mainViewModel.setNumberBack(Fields.ON_BACK);
    }

    @Override
    public void onClick(View v) {
        if (DataUtils.getInstance().getCustomer() == null) {
            // not logged in
            Toast.makeText(getContext(), "Cần đăng nhập để sử dụng chức năng!", Toast.LENGTH_SHORT).show();
        } else {
            mainViewModel.setmCustomer(DataUtils.getInstance().getCustomer());
            switch (v.getId()) {
                case R.id.ivNeo:
                case R.id.layoutNeo:
                    Intent intentNeo = new Intent(getContext(), TestActivity.class);
                    intentNeo.putExtra(Define.TYPE_QUESTION, Define.Question.TYPE_NEO);
                    startActivity(intentNeo);
                    // getActivity().overridePendingTransition(R.anim.fade_left, R.anim.no_anim);
                    break;
                case R.id.ivRiasec:
                case R.id.layoutRiasec:
                    Intent intentRisec = new Intent(getContext(), TestActivity.class);
                    intentRisec.putExtra(Define.TYPE_QUESTION, Define.Question.TYPE_RIASEC);
                    startActivity(intentRisec);
                    // getActivity().overridePendingTransition(R.anim.fade_left, R.anim.no_anim);
                    break;
                case R.id.ivPsy:
                case R.id.layoutPsy:
                    Intent intentPsy = new Intent(getContext(), TestActivity.class);
                    intentPsy.putExtra(Define.TYPE_QUESTION, Define.Question.TYPE_PSY_POCHOLIGICAL);
                    startActivity(intentPsy);
                    // getActivity().overridePendingTransition(R.anim.fade_left, R.anim.no_anim);
                    break;
                default:
                    break;
            }
        }
    }
}
