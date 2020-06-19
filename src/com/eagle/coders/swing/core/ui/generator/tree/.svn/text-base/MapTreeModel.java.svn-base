/**
 * 
 */
package com.eagle.coders.swing.core.ui.generator.tree;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.swing.event.EventListenerList;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;


/**
 * @author Anees
 *
 */
public class MapTreeModel implements TreeModel, Serializable, Cloneable{

	 protected EventListenerList listeners = new EventListenerList();

	    private Map map;

	    private Object root;


	    public MapTreeModel(Map map, Object root){
	        this.map = map;

	        this.root = root;
	    }


	    public Object getRoot(){
	        return root;
	    }

	    public boolean isLeaf(Object node){
	    	
	        return !map.containsKey(node);
	    }

	    public int getChildCount(Object parent){
	    	
	        List children = (List)map.get(parent);
	 
	        return children == null
	            ? 0 : children.size();
	    }

	    public Object getChild(Object parent, int index){
	    	
	        return ((List)map.get(parent)).get(index);
	    }

	    public int getIndexOfChild(Object parent, Object child){
	    	
	        return ((List)map.get(parent)).indexOf(child);
	    }


	    public void valueForPathChanged(TreePath path, Object value){
	    }


	    public void addTreeModelListener(TreeModelListener l){
	        listeners.add(TreeModelListener.class, l);
	    }

	    public void removeTreeModelListener(TreeModelListener l){
	        listeners.remove(TreeModelListener.class, l);
	    }

	    public Object clone(){
	        try{
	            MapTreeModel clone = (MapTreeModel)super.clone();

	            clone.listeners = new EventListenerList();

	            return clone;
	        }catch (CloneNotSupportedException e){
	            throw new InternalError();
	        }
	    }
}
