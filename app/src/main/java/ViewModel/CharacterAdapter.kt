package ViewModel

import Data.IMAGE_TYPE
import Data.NAME_TYPE
import Data.Results
import Data.SPECIES_TYPE
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mobilelab2_2.R
import com.squareup.picasso.Picasso

class CharacterAdapter(private val context: Context, private val list: Array<Results>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ImageViewHolder(view: View): RecyclerView.ViewHolder(view){
        val image = view.findViewById<ImageView>(R.id.imageView)
    }

    class NameViewHolder(view: View): RecyclerView.ViewHolder(view){
        val Name = view.findViewById<TextView>(R.id.name_text)
    }

    class SpeciesViewHolder(view: View): RecyclerView.ViewHolder(view){
        val Species = view.findViewById<TextView>(R.id.species_text)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == IMAGE_TYPE){
            val view = LayoutInflater.from(context).inflate(R.layout.activity_image_item, parent, false)
            return ImageViewHolder(view)
        }
        if(viewType == NAME_TYPE){
            val view = LayoutInflater.from(context).inflate(R.layout.activity_name_item, parent, false)
            return NameViewHolder(view)
        } else{
            val view = LayoutInflater.from(context).inflate(R.layout.activity_species_item, parent, false)
            return SpeciesViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].getTypeCharatcer()
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = list[position]

        if(holder.itemViewType == IMAGE_TYPE){
            val url = data.image
            Picasso.get().load(url).into((holder as ImageViewHolder).image)
        }
        if(holder.itemViewType == NAME_TYPE){
            (holder as NameViewHolder).Name.text = data.name
        }
        if(holder.itemViewType == SPECIES_TYPE){
            (holder as SpeciesViewHolder).Species.text = data.species
        }
    }
}