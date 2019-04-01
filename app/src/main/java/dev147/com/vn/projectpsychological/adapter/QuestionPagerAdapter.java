package dev147.com.vn.projectpsychological.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;
import dev147.com.vn.projectpsychological.R;
import dev147.com.vn.projectpsychological.data.model.Question;
import dev147.com.vn.projectpsychological.ui.test.test_step_two.TestStepTwoViewModel;
import dev147.com.vn.projectpsychological.utils.Define;
import dev147.com.vn.projectpsychological.utils.Fields;
import dev147.com.vn.projectpsychological.utils.Utils;

public class QuestionPagerAdapter extends PagerAdapter {
    private List<Question> questions;
    private Context context;
    private SaveResult saveResult;
    private RadioGroup rGroup;
    private TextView tvContent;
    private TextView tvTheme;
    private TestStepTwoViewModel viewModel;
    private int type;

    private RadioButton btn01;
    private RadioButton btn02;
    private RadioButton btn03;
    private RadioButton btn04;
    private RadioButton btn05;


    public QuestionPagerAdapter(Context context, List<Question> questions, TestStepTwoViewModel viewModel, int type) {
        this.context = context;
        this.questions = questions;
        this.viewModel = viewModel;
        this.type = type;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        Log.d("QUANGANH", "instantiateItem: " + position);
        View view = LayoutInflater.from(context).inflate(R.layout.detail_question, container, false);
        tvContent = view.findViewById(R.id.tvContent);
        tvContent.setTypeface(Utils.getTypeFace(context, Fields.FONT_TIMES));
        btn01 = view.findViewById(R.id.btnResult01);
        btn02 = view.findViewById(R.id.btnResult02);
        btn03 = view.findViewById(R.id.btnResult03);
        btn04 = view.findViewById(R.id.btnResult04);
        btn05 = view.findViewById(R.id.btnResult05);

        if (type == Define.Question.TYPE_RIASEC) {
            btn01.setText("Hoàn toàn không đúng");
            btn02.setText("Không đúng");
            btn03.setText("Đúng một phần");
            btn04.setText("Đúng");
            btn05.setText("Hoàn toàn đúng");
        }

        tvTheme = view.findViewById(R.id.tvTheme);

        tvContent.setText(context.getResources().getString(R.string.content_question, questions.get(position).getNumberId(), questions.get(position).getContent()));
        container.addView(view);
        rGroup = view.findViewById(R.id.layoutResult);

        int type = questions.get(0).getType().intValue();
        if (type == Define.Question.TYPE_NEO || type == Define.Question.TYPE_RIASEC) {
            tvTheme.setVisibility(View.GONE);
        }

        if (viewModel.getDataResults(position) != -1) {
            switch (viewModel.getDataResults(position)) {
                case 0:
                    btn01.setChecked(true);
                    break;
                case 1:
                    btn02.setChecked(true);
                    break;
                case 2:
                    btn03.setChecked(true);
                    break;
                case 3:
                    btn04.setChecked(true);
                    break;
                case 4:
                    btn05.setChecked(true);
                    break;
                default:
                    break;
            }
        }
        rGroup.setOnCheckedChangeListener((radioGroub, checkedId) -> {
            int selected;
            switch (checkedId) {
                case R.id.btnResult01:
                    selected = 0;
                    break;
                case R.id.btnResult02:
                    selected = 1;
                    break;
                case R.id.btnResult03:
                    selected = 2;
                    break;
                case R.id.btnResult04:
                    selected = 3;
                    break;
                case R.id.btnResult05:
                    selected = 4;
                    break;
                default:
                    selected = -1;
                    break;
            }
            saveResult.onSaveDataResult(position, selected);
        });


        return view;
    }

    @Override
    public int getCount() {
        return questions.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }

    @Override
    public void notifyDataSetChanged() {
        Log.d("QUANGANH", "notifyDataSetChanged: vào đây");
        super.notifyDataSetChanged();
    }

    public void setSaveResult(SaveResult saveResult) {
        this.saveResult = saveResult;
    }

    public interface SaveResult {
        void onSaveDataResult(int position, int result);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return String.valueOf(position + 1);
    }
}
