package com.openclassrooms.myrepo.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.progressindicator.LinearProgressIndicator;
import com.openclassrooms.myrepo.R;
import com.openclassrooms.myrepo.model.Task;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Un adaptateur pour afficher la liste de tâches dans un RecyclerView.
 */
public class TaskRecyclerViewAdapter extends ListAdapter<Task, TaskRecyclerViewAdapter.ViewHolder> {

    /**
     * Constructeur de l'adaptateur.
     */
    public TaskRecyclerViewAdapter() {
        super(new ItemCallback());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.task_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(getItem(position));
    }

    /**
     * ViewHolder pour afficher les éléments de la liste de tâches.
     */
    static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView factTextView;
        private final TextView dueTimeTextView;
        private final LinearProgressIndicator progressIndicator;


        /**
         * Constructeur du ViewHolder.
         */
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            factTextView = itemView.findViewById(R.id.task_description);
            dueTimeTextView = itemView.findViewById(R.id.due_time);
            progressIndicator = itemView.findViewById(R.id.progress_horizontal);
        }

        /**
         * Lie les données de la tâche au ViewHolder.
         *
         * @param task La tâche à afficher.
         */
        public void bind(Task task) {

            // affiche le nom de la tâche
            factTextView.setText(task.getDescription());

            // Création d'un format de date
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());

            // Conversion de la date de la tâche
            String formattedDate = dateFormat.format(task.getDueTime());

            // affiche la date de la tâche
            dueTimeTextView.setText(String.format("Date d'échéance : %s", formattedDate));

            // création de la variable 'pourcentage' pour la barre de progression
            int pourcentage = calculateProgress(task.getDueTime());
            progressIndicator.setProgress(pourcentage);

        }

        private int calculateProgress(Date dueTime) {
            Calendar dateDuJour = Calendar.getInstance();
            dateDuJour.set(Calendar.HOUR_OF_DAY, 0);
            dateDuJour.set(Calendar.MINUTE, 0);
            dateDuJour.set(Calendar.SECOND, 0);
            dateDuJour.set(Calendar.MILLISECOND, 0);

            Calendar dateTache = Calendar.getInstance();
            dateTache.setTime(dueTime);
            dateTache.set(Calendar.HOUR_OF_DAY, 0);
            dateTache.set(Calendar.MINUTE, 0);
            dateTache.set(Calendar.SECOND, 0);
            dateTache.set(Calendar.MILLISECOND, 0);

            int joursRestants = (int) ((dateTache.getTimeInMillis() -
                    dateDuJour.getTimeInMillis()) / (24 * 3600 * 1000));
            return 100 - (joursRestants * 10);


        }

        /* Ancien code
        private int calculateProgress(Date dueTime) {
            Calendar dateDuJour = Calendar.getInstance();
            Calendar dateTache = Calendar.getInstance();
            dateTache.setTime(dueTime);
            int joursRestants = (int) (dateTache.getTimeInMillis() - dateDuJour.getTimeInMillis())/(24*3600*1000);
            return 100 - (joursRestants*10);
        }*/

    }

    /**
     * Callback pour la comparaison des éléments de la liste.
     */
    private static class ItemCallback extends DiffUtil.ItemCallback<Task> {
        @Override
        public boolean areItemsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem.getDescription().equals(newItem.getDescription());
        }

        @Override
        public boolean areContentsTheSame(@NonNull Task oldItem, @NonNull Task newItem) {
            return oldItem.equals(newItem);
        }
    }
}
