package newPackage1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newkeyboard.R;

import java.util.List;

public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiViewHolder> {
    private final List<String> emojiList;
    private final OnEmojiClickListener emojiClickListener;

    public interface OnEmojiClickListener {
        void onEmojiClick(String emoji);
    }

    public EmojiAdapter(List<String> emojiList, OnEmojiClickListener listener) {
        this.emojiList = emojiList;
        this.emojiClickListener = listener;
    }

    @NonNull
    @Override
    public EmojiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.emoji_item, parent, false);
        return new EmojiViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiViewHolder holder, int position) {
        String emoji = emojiList.get(position);
        holder.bind(emoji, emojiClickListener);
    }

    @Override
    public int getItemCount() {
        return emojiList.size();
    }

    static class EmojiViewHolder extends RecyclerView.ViewHolder {
        private final TextView emojiTextView;

        public EmojiViewHolder(View itemView) {
            super(itemView);
            emojiTextView = itemView.findViewById(R.id.idEmojiText);
        }

        public void bind(String emoji, OnEmojiClickListener listener) {
            emojiTextView.setText(emoji);
            itemView.setOnClickListener(v -> listener.onEmojiClick(emoji));
        }
    }
}
