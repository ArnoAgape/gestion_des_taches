package com.openclassrooms.myrepo.data.service;

import com.openclassrooms.myrepo.model.Task;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Cette classe simule la récupération de tâches depuis une API.
 * Les tâches générées sont utilisées à des fins de démonstration.
 */
public class TaskApi {


    /**
     * Récupère une liste de tâches simulées depuis l'API.
     *
     * @return Une liste de tâches simulées avec des descriptions pré-définies.
     */
    public List<Task> getTasks() {

        // Simule la récupération des tâches depuis une API
        List<Task> tasks = new ArrayList<>();

        Calendar calendrier = Calendar.getInstance();
        calendrier.setTime(new Date()); // Date actuelle

        tasks.add(new Task("Faire les courses pour le dîner", calendrier.getTime()));
        calendrier.add(Calendar.DAY_OF_YEAR, 1);
        tasks.add(new Task("Préparer le rapport pour la réunion", calendrier.getTime()));
        calendrier.add(Calendar.DAY_OF_YEAR, 1);
        tasks.add(new Task("Répondre aux e-mails en attente", calendrier.getTime()));
        calendrier.add(Calendar.DAY_OF_YEAR, 1);
        tasks.add(new Task("Faire de l'exercice pendant 30 minutes", calendrier.getTime()));
        calendrier.add(Calendar.DAY_OF_YEAR, 1);
        tasks.add(new Task("Planifier les vacances d'été", calendrier.getTime()));
        calendrier.add(Calendar.DAY_OF_YEAR, 1);
        tasks.add(new Task("Rendre le livre à la bibliothèque", calendrier.getTime()));
        calendrier.add(Calendar.DAY_OF_YEAR, 1);
        tasks.add(new Task("Réviser pour l'examen de mathématiques", calendrier.getTime()));
        calendrier.add(Calendar.DAY_OF_YEAR, 1);
        tasks.add(new Task("Appeler le plombier pour la fuite d'eau", calendrier.getTime()));
        calendrier.add(Calendar.DAY_OF_YEAR, 1);
        tasks.add(new Task("Nettoyer le garage", calendrier.getTime()));
        calendrier.add(Calendar.DAY_OF_YEAR, 1);
        tasks.add(new Task("Préparer une liste de courses", calendrier.getTime()));
        calendrier.add(Calendar.DAY_OF_YEAR, 1);
        return tasks;
    }

}

