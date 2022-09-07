package mx.com.miguel.miketheme.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Map;

import mx.com.miguel.miketheme.R;


public class AdaptadorAccordions extends BaseExpandableListAdapter {
    private ArrayList<String> preguntas;
    private Map<String,ArrayList<String>> respuestas;
    private Context context;

    public AdaptadorAccordions(ArrayList<String> preguntas, Map<String, ArrayList<String>> respuestas, Context context) {
        this.preguntas = preguntas;
        this.respuestas = respuestas;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return preguntas.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return respuestas.get(preguntas.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return preguntas.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return respuestas.get(preguntas.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String preguntaFaq = (String) getGroup(groupPosition);
        convertView = LayoutInflater.from(context).inflate(R.layout.item_accordion_header, null);
        TextView tv_pregunta = (TextView)convertView.findViewById(R.id.pregunta_faq);
        tv_pregunta.setText(preguntaFaq);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
       String respuesta = (String) getChild(groupPosition, childPosition);
       convertView = LayoutInflater.from(context).inflate(R.layout.item_accordion_content, null);
       TextView tv_respuesta = (TextView) convertView.findViewById(R.id.respuesta_faq);
       tv_respuesta.setText(respuesta);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
