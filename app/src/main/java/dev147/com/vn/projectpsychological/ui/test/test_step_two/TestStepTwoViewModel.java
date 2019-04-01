package dev147.com.vn.projectpsychological.ui.test.test_step_two;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import dev147.com.vn.projectpsychological.data.base.ObjectResponse;
import dev147.com.vn.projectpsychological.data.model.Result;
import dev147.com.vn.projectpsychological.data.model.ResultNeo;
import dev147.com.vn.projectpsychological.data.model.ResultRiasec;
import dev147.com.vn.projectpsychological.data.repository.ResultRespository;
import io.reactivex.disposables.CompositeDisposable;

public class TestStepTwoViewModel extends ViewModel {
    private CompositeDisposable compositeDisposable;
    private ResultRespository resultRespository;
    private MutableLiveData<ObjectResponse<Long>> isInsertResultNeo;
    private MutableLiveData<ObjectResponse<Long>> isInsertResultRiasec;
    private MutableLiveData<ObjectResponse<Long>> isInsertResultPsy;
    private MutableLiveData<ObjectResponse<Long>> isInsertResult;
    private int[] results;

    @Inject
    TestStepTwoViewModel(ResultRespository resultRespository) {
        this.resultRespository = resultRespository;
        compositeDisposable = new CompositeDisposable();
        isInsertResultNeo = new MutableLiveData<>();
        isInsertResult = new MutableLiveData<>();
        isInsertResultRiasec = new MutableLiveData<>();
        isInsertResultPsy = new MutableLiveData<>();
    }

    public void insertResultNeo(ResultNeo resultNeo) {
        compositeDisposable.add(
                resultRespository.insertResultNeo(resultNeo)
                        .doOnSubscribe(dispose -> isInsertResultNeo.setValue(new ObjectResponse<Long>().loading()))
                        .subscribe(response -> isInsertResultNeo.setValue(new ObjectResponse<Long>().success(response))
                                , throwable -> isInsertResultNeo.setValue(new ObjectResponse<Long>().error(throwable)))
        );
    }

    public void insertResult(Result result) {
        compositeDisposable.add(
                resultRespository.insertResult(result)
                        .doOnSubscribe(dispose -> isInsertResult.setValue(new ObjectResponse<Long>().loading()))
                        .subscribe(response -> isInsertResult.setValue(new ObjectResponse<Long>().success(response))
                                , throwable -> isInsertResult.setValue(new ObjectResponse<Long>().error(throwable)))
        );
    }

    public void insertResultRiasec(ResultRiasec resultRiasec) {
        compositeDisposable.add(
                resultRespository.insertResultRiasec(resultRiasec)
                        .doOnSubscribe(dispose -> isInsertResultRiasec.setValue(new ObjectResponse<Long>().loading()))
                        .subscribe(response -> isInsertResultRiasec.setValue(new ObjectResponse<Long>().success(response))
                                , throwable -> isInsertResultRiasec.setValue(new ObjectResponse<Long>().error(throwable)))
        );
    }

    public void initResults(int size) {
        results = new int[size];
        for (int i = 0; i < size; i++) {
            results[i] = -1;
        }
//        results = new int[]{2, 1, 3, 0, 1, 2, 0, 0, 1, 1, 2, 3, 3, 1, 3, 2, 3, 3, 3, 3, 2, 2, 1, 4, 4, 1, 2, 3, 3, 3, 1, 2, 3, 3, 1, 1, 3, 3, 1, 2, 2, 3, 1, 3, 3, 1, 0, 2, 0, 3, 3, 2, 3, 0, 3, 2, 3, 2, 0, 4,};
//        results = new int[]{1, 2, 1, 0, 3, 4, 0, 2, 1, 3, 2, 2, 1, 0, 2, 4, 0, 2, 1, 3, 4, 3, 2, 1, 2, 3, 2, 1, 4, 0, 4, 2, 2, 3, 2, 1, 3, 3, 0, 0, 1, 1, 2, 2, 3, 3, 2, 3, 3, 0, 0, 1, 1, 2, 0, 2, 1, 2, 1, 3, 2, 4, 3, 1, 2, 0, 0, 1, 2, 3, 2, 2, 1, 4, 2, 1, 3, 2, 2, 3, 1, 2, 1, 2, 3, 4, 0, 1, 0, 3, 3, 2, 0, 1, 0, 2, 1, 3, 2, 1, 4, 3, 0, 0, 1, 3, 2, 2, 1, 1, 2, 3, 4, 2, 1, 0, 1, 3, 4, 2, 3, 2, 0, 0, 2, 2, 0, 1, 2, 3, 4, 1, 1, 1, 2, 1, 3};
    }

    public void setDataResults(int position, int result) {
        results[position] = result;
    }

    public int getDataResults(int position) {
        return results[position];
    }

    public int[] getResuls() {
        return results;
    }


    public MutableLiveData<ObjectResponse<Long>> getIsInsertResultNeo() {
        return isInsertResultNeo;
    }

    public void setIsInsertResultNeo(ObjectResponse<Long> value) {
        isInsertResultNeo.setValue(value);
    }

    public MutableLiveData<ObjectResponse<Long>> getIsInsertResultRiasec() {
        return isInsertResultRiasec;
    }

    public void setIsInsertResultRiasec(ObjectResponse<Long> value) {
        isInsertResultRiasec.setValue(value);
    }

    public MutableLiveData<ObjectResponse<Long>> getIsInsertResultPsy() {
        return isInsertResultPsy;
    }

    public void setIsInsertResultPsy(ObjectResponse<Long> value) {
        isInsertResultPsy.setValue(value);
    }

    public MutableLiveData<ObjectResponse<Long>> getIsInsertResult() {
        return isInsertResult;
    }

    public void setIsInsertResult(ObjectResponse<Long> value) {
        isInsertResult.setValue(value);
    }

    public ResultNeo getResulNeo() {
        int c = 0;
        int a = 0;
        int o = 0;
        int n = 0;
        int e = 0;
        for (int i = 0; i < results.length; i++) {
            switch (i % 5) {
                case 0:
                    c += results[i];
                    break;
                case 1:
                    a += results[i];
                    break;
                case 2:
                    o += results[i];
                    break;
                case 3:
                    n += results[i];
                    break;
                case 4:
                    e += results[i];
                    break;
            }
        }
        return new ResultNeo(n, e, o, a, c);
    }

    public ResultRiasec getResultRiasec() {
        int reality = 0;
        int discover = 0;
        int art = 0;
        int society = 0;
        int convince = 0;
        int rule = 0;
        for (int i = 0; i < results.length; i++) {
            int point = results[i] == 0 || results[i] == 1 ? 0 : 1;
            if (i == 0 || i == 6 || i == 12 || i == 18 || i == 24 || i == 30 || i == 36 || i == 42 ||
                    i == 48 || i == 54 || i == 60 || i == 66 || i == 72 || i == 78 || i == 84 || i == 90 ||
                    i == 96 || i == 102 || i == 108 || i == 114 || i == 120 || i == 126 || i == 131 || i == 134) {
                // khám phá
                discover += point;
            } else if (i == 1 || i == 7 || i == 13 || i == 19 || i == 25 || i == 31 || i == 37 || i == 43 || i == 49 ||
                    i == 55 || i == 61 || i == 67 || i == 73 || i == 79 || i == 85 || i == 91 || i == 97 || i == 103 ||
                    i == 109 || i == 115 || i == 121 || i == 127 || i == 132 || i == 135) {
                // nghệ thuật
                art += point;
            } else if (i == 2 || i == 8 || i == 14 || i == 20 || i == 26 || i == 32 || i == 38 || i == 44 || i == 50 ||
                    i == 56 || i == 62 || i == 68 || i == 74 || i == 80 || i == 86 || i == 92 || i == 98 || i == 104 ||
                    i == 110 || i == 116 || i == 122 || i == 128) {
                // quy tắc
                rule += point;
            } else if (i == 3 || i == 9 || i == 15 || i == 21 || i == 27 || i == 33 || i == 39 || i == 45 || i == 51 ||
                    i == 57 || i == 63 || i == 69 || i == 75 || i == 81 || i == 87 || i == 93 || i == 99 || i == 105 ||
                    i == 111 || i == 117 || i == 123 || i == 129) {
                // thuyết phục
                convince += point;
            } else if (i == 4 || i == 10 || i == 16 || i == 22 || i == 28 || i == 34 || i == 40 || i == 46 || i == 52 ||
                    i == 58 || i == 64 || i == 70 || i == 76 || i == 82 || i == 88 || i == 94 || i == 100 || i == 106 ||
                    i == 112 || i == 118 || i == 124) {
                // thực tế
                reality += point;
            } else {
                // xã hội
                society += point;
            }
        }
        return new ResultRiasec(rule, society, discover, reality, art, convince);
    }
}
