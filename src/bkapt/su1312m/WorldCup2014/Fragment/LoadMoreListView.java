package bkapt.su1312m.WorldCup2014.Fragment;

import bkapt.su1312m.WorldCup2014.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

public class LoadMoreListView extends ListView implements OnScrollListener {

	private OnScrollListener mOnScrollListener;
	
	private LayoutInflater mLayoutInflater;
	
	private RelativeLayout mFooterView;
	
	private ProgressBar mProgressBar;
	
	private OnLoadMoreListener mOnLoadMoreListener;
	
	private boolean mIsLoadingMore = false;
	
	private int mCurrentScrollState;
	
	private boolean mIsFinishLoadAll = false;
	
	public LoadMoreListView(Context context) {
		super(context);
		init(context);
	}

	public LoadMoreListView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public LoadMoreListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}
	
	public void init(Context context) {
		mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mFooterView = (RelativeLayout) mLayoutInflater.inflate(R.layout.load_more_footer, this, false);
		mProgressBar = (ProgressBar) mFooterView.findViewById(R.id.load_more_progressBar);
		addFooterView(mFooterView);
		super.setOnScrollListener(this);
	}
	
	@Override
	public void setAdapter(ListAdapter adapter) {
		super.setAdapter(adapter);
	}

	@Override
	public void setOnScrollListener(OnScrollListener l) {
		mOnScrollListener = l;
	}
	
	public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
		mOnLoadMoreListener = onLoadMoreListener;
	}

	public void onScroll(AbsListView view, int firstVisibleItem,int visibleItemCount, int totalItemCount) {
		if(mOnScrollListener != null) {
			mOnScrollListener.onScroll(view, firstVisibleItem, visibleItemCount, totalItemCount);
		}
		if(mOnLoadMoreListener != null && mIsFinishLoadAll == false) {
			if (visibleItemCount == totalItemCount) {
				mFooterView.setVisibility(View.GONE);
				return;
			}
			boolean loadmore = firstVisibleItem + visibleItemCount >= totalItemCount;
			if(!mIsLoadingMore && loadmore && mCurrentScrollState != SCROLL_STATE_IDLE) {
				mIsLoadingMore = true;
				mFooterView.setVisibility(View.VISIBLE);
				onLoadMore();
			}
		}
	}

	public void onScrollStateChanged(AbsListView view, int scrollState) {
		mCurrentScrollState = scrollState;
		if(mOnScrollListener != null) {
			mOnScrollListener.onScrollStateChanged(view, scrollState);
		}
	}
	
	public void setFinishLoadAll() {
		mIsFinishLoadAll = true;
		mFooterView.setVisibility(View.GONE);
	}
	
	public void onLoadMore() {
		mProgressBar.setVisibility(View.VISIBLE);
		if(mOnLoadMoreListener != null) {
			mOnLoadMoreListener.onLoadMore();
		}
	}
	
	public void onLoadMoreComplete() {
		mProgressBar.setVisibility(View.GONE);
		mIsLoadingMore = false;
	}
	
	public interface OnLoadMoreListener {
		public void onLoadMore();
	}
 
}
