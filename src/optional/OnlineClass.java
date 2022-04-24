package optional;

import java.util.Optional;

public class OnlineClass {
	
	private Integer id;
	private String title;
	private boolean closed;
	public Progress progress; 
	
	
	public Optional<Progress> getProgress() {
		return Optional.ofNullable(progress);
	}

	public void setProgress(Progress progress) {
		this.progress = progress;
	}
	
	/*null이 사용될 수 있으니 사용 주의*/
//	public void setProgress(Optional<Progress> progress) {
//		progress.ifPresent((prg) -> this.progress = prg );
//	}

	public OnlineClass(Integer id, String title, boolean closed) {
		this.id = id;
		this.title = title;
		this.closed = closed;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

}
