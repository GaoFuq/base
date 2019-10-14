package com.gfq.base.activity;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import com.gfq.base.viewmodel.GViewModel;
import com.kingja.loadsir.callback.Callback;
import com.kingja.loadsir.core.LoadService;
import com.kingja.loadsir.core.LoadSir;

/**
 * create by 高富强
 * on {2019/10/14} {11:20}
 * desctapion:
 */
public abstract class BaseMvvmActivity<BaseBinding extends ViewDataBinding, VM extends GViewModel> extends AppCompatActivity {
    protected VM mViewModel;
    protected BaseBinding mBaseBinding;
    private LoadService mLoadService;
    public abstract int layout();

    protected abstract VM getViewModel();

    public abstract int getBindingVar();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDataBinding();

    }

    public void setLoadSir(View view) {
        LoadSir.getDefault().register(view, new Callback.OnReloadListener() {
            @Override
            public void onReload(View v) {

            }
        });
    }

    private void performDataBinding() {
        mBaseBinding = DataBindingUtil.setContentView(this, layout());
        mViewModel = getViewModel();
        if (mViewModel != null){
            if(getBindingVar()>0){
                mBaseBinding.setVariable(getBindingVar(), mViewModel);
            }else {
                throw new  RuntimeException("getBindingVar 要大于0");
            }
        }else {
            throw new  RuntimeException("viewModel 不能为空");
        }

        mBaseBinding.executePendingBindings();



    }



}
