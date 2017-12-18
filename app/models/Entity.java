package models;

/**
 * @author Marlon Kewaldar
 * This interface represents an entity, which is the base for all objects within the Model subfolder.
 * Java Play requires certain interfaces to be present in classes, so this will serve as a good way for every
 * entity to return itself.
 */

interface Entity {

    Entity returnSelf();

}
