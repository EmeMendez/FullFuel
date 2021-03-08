package com.fuel.fullfuel.adaptadores;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.fuel.fullfuel.MostrarGasolinera;
import com.fuel.fullfuel.R;
import com.fuel.fullfuel.clases.Gasolinera;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class GasolineraAdaptador extends RecyclerView.Adapter<GasolineraAdaptador.ViewHolder> implements View.OnClickListener {

    private ArrayList<Gasolinera> gasolineras;
    private View.OnClickListener click;
    private Context context;


    public GasolineraAdaptador(Context context, ArrayList<Gasolinera> gasolineras) {
        this.gasolineras = gasolineras;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_lista_gasolinera, null, false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Gasolinera gasolinera  = gasolineras.get(position);
        holder.nombre.setText(gasolineras.get(position).getDistribuidor().getNombre());
        holder.tipoAviso.setText(gasolineras.get(position).getNombre_comuna());
        holder.Descripcion.setText(gasolineras.get(position).getRazon_social());
        Picasso.get().load(gasolineras.get(position).getDistribuidor().getLogo()).into(holder.imagen);


        if(gasolineras.get(position).getPrecios().getGasolina_93() == null){
            holder.layout_93.setVisibility(View.GONE);
        }else{
            holder.layout_93.setVisibility(View.VISIBLE);
            holder.precio_93.setText("$ " + gasolineras.get(position).getPrecios().getGasolina_93());
        }

        if(gasolineras.get(position).getPrecios().getGasolina_95() == null){
            holder.layout_95.setVisibility(View.GONE);
        }else{
            holder.layout_95.setVisibility(View.VISIBLE);
            holder.precio_95.setText("$ " + gasolineras.get(position).getPrecios().getGasolina_95());
        }

        if(gasolineras.get(position).getPrecios().getGasolina_97() == null){
            holder.layout_97.setVisibility(View.GONE);
        }else{
            holder.layout_97.setVisibility(View.VISIBLE);
            holder.precio_97.setText("$ " + gasolineras.get(position).getPrecios().getGasolina_97());
        }

        if(gasolineras.get(position).getPrecios().getPetroleo_diesel() == null){
            holder.layout_diesel.setVisibility(View.GONE);
        }else{
            holder.layout_diesel.setVisibility(View.VISIBLE);
            holder.precio_diesel.setText("$ " + gasolineras.get(position).getPrecios().getPetroleo_diesel());
        }

        if(gasolineras.get(position).getPrecios().getGlp_vehicular() == null){
            holder.layout_glp.setVisibility(View.GONE);
        }else{
            holder.layout_glp.setVisibility(View.VISIBLE);
            holder.precio_glp.setText("$ " + gasolineras.get(position).getPrecios().getGlp_vehicular());
        }





        holder.layout.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, MostrarGasolinera.class);
                i.putExtra("id", gasolinera.getId());

                i.putExtra("nombre", gasolinera.getDistribuidor().getNombre());

                //ubicacion
                i.putExtra("latitud", gasolinera.getUbicacion().getLatitud());
                i.putExtra("longitud", gasolinera.getUbicacion().getLongitud());

                //datos básicos
                i.putExtra("actualizacion", gasolinera.getFecha_hora_actualizacion());
                i.putExtra("razon_social", gasolinera.getRazon_social());
                i.putExtra("direccion", gasolinera.getDireccion_calle() + " #" + gasolinera.getDireccion_numero());
                i.putExtra("comuna", gasolinera.getNombre_comuna());


                //medios de pago
                i.putExtra("efectivo", gasolinera.getMetodos_de_pago().getEfectivo());
                i.putExtra("cheque", gasolinera.getMetodos_de_pago().getCheque());
                i.putExtra("bancarias", gasolinera.getMetodos_de_pago().getTarjetas_bancarias());
                i.putExtra("tiendas", gasolinera.getMetodos_de_pago().getTarjetas_grandes_tiendas());



                //precios
                i.putExtra("gasolina_93", gasolinera.getPrecios().getGasolina_93());
                i.putExtra("gasolina_95",  gasolinera.getPrecios().getGasolina_95());
                i.putExtra("gasolina_97",  gasolinera.getPrecios().getGasolina_97());
                i.putExtra("pretroleo_diesel", gasolinera.getPrecios().getPetroleo_diesel());
                i.putExtra("glp_vehicular", gasolinera.getPrecios().getGlp_vehicular());

                //servicios
                i.putExtra("tienda", gasolinera.getServicios().getTienda());
                i.putExtra("farmacia",  gasolinera.getServicios().getFarmacia());
                i.putExtra("mantencion",  gasolinera.getServicios().getMantencion());
                i.putExtra("autoservicio", gasolinera.getServicios().getAutoservicio());

                context.startActivity(i);
            }

        });


    }

    @Override
    public int getItemCount() {
        return gasolineras.size();
    }
    public void setOnClickListener(View.OnClickListener click){
        this.click = click;
    }
    @Override
    public void onClick(View v) {
        if(click!=null){
            click.onClick(v);
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imagen;
        TextView nombre, Descripcion;
        RelativeLayout layout;
        ImageView estrella;
        TextView tipoAviso;
        TextView precio_93;
        TextView precio_95;
        TextView precio_97;
        TextView precio_diesel;
        TextView precio_glp;

        LinearLayout layout_93;
        LinearLayout layout_95;
        LinearLayout layout_97;
        LinearLayout layout_diesel;
        LinearLayout layout_glp;


        public ViewHolder(View view) {
            super(view);
            imagen = (ImageView) itemView.findViewById(R.id.imagen);
            nombre = (TextView) itemView.findViewById(R.id.nombre);
            Descripcion = (TextView) itemView.findViewById(R.id.descripcion);
            estrella = itemView.findViewById(R.id.favorito);
            tipoAviso = (TextView)  itemView.findViewById(R.id.tipo_aviso);

            precio_93 = (TextView) itemView.findViewById(R.id.precio_93);
            precio_95 = (TextView) itemView.findViewById(R.id.precio_95);
            precio_97 = (TextView) itemView.findViewById(R.id.precio_97);
            precio_diesel = (TextView) itemView.findViewById(R.id.precio_diesel);
            precio_glp = (TextView) itemView.findViewById(R.id.precio_glp);


            layout = itemView.findViewById(R.id.layout);

            layout_93 = itemView.findViewById(R.id.layout_93);
            layout_95 = itemView.findViewById(R.id.layout_95);
            layout_97 = itemView.findViewById(R.id.layout_97);
            layout_diesel = itemView.findViewById(R.id.layout_diesel);
            layout_glp = itemView.findViewById(R.id.layout_glp);
        }

    }
}