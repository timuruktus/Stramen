package ru.timuruktus.stramen.presentation.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ahamed.multiviewadapter.BaseViewHolder;
import com.ahamed.multiviewadapter.ItemBinder;
import com.ahamed.multiviewadapter.ItemViewHolder;

import butterknife.ButterKnife;
import ru.timuruktus.stramen.R;
import ru.timuruktus.stramen.models.entities.project_levels.IProject;

class CarBinder extends ItemBinder<IProject, CarBinder.CarViewHolder>{

    @Override
    public CarViewHolder create(LayoutInflater inflater, ViewGroup parent){
        return new CarViewHolder(inflater.inflate(R.layout.project, parent, false));
    }

    @Override
    public boolean canBindData(Object item){
        return item instanceof IProject;
    }

    @Override
    public void bind(CarViewHolder holder, IProject item){
        // Bind the data here
        holder.setData(item);
    }

    static class CarViewHolder extends ItemViewHolder<IProject>{

        private View view;
        private IProject project;


        public CarViewHolder(View itemView){
            super(itemView);
            this.view = itemView;
            ButterKnife.bind(this, itemView);
        }

        void setData(IProject project){

        }


    }
}
