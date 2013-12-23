package jp.gr.java_conf.tycorp.list;

import java.util.List;

import jp.gr.java_conf.tycorp.R;
import jp.gr.java_conf.tycorp.utils.EitangoKbnConstant;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class EitangoListAdapter extends ArrayAdapter<EitangoListItem> {

	private LayoutInflater mLayoutInflater;

	private EitangoListMakerDatabaseImpl maker;


	/**
	 * �R���X�g���N�^
	 *
	 * @param context
	 * @param resource
	 * @param textViewResourceId
	 * @param objects
	 */
	public EitangoListAdapter(Context context, int resource,
			int textViewResourceId, List<EitangoListItem> objects, EitangoListMakerDatabaseImpl maker) {

		super(context, resource, textViewResourceId, objects);
		mLayoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		this.maker = maker;
	}


	@Override
	public int getItemViewType(int position) {
		return getItem(position).getLayoutStyle();
	}


	@Override
	public int getViewTypeCount() {
		return 2;
	}

	/**
	 * ���X�g�A�C�e�����I���i�^�b�`�j���ꂽ�ꍇ�Ɏ��s����鏈��
	 */
	public void selectListItem(int position) {

		// �I���A�C�e���̕\���`����ύX
		EitangoListItem item = (EitangoListItem) getItem(position);
		item.changeLayoutStyle();

		// �ύX��ʒm
		this.notifyDataSetChanged();
	}

	/**
	 * �r���[�擾
	 */
	@Override
	public View getView(final int position, View convertView,
			final ViewGroup parent) {

		// ���X�g�A�C�e������
		EitangoListItem item = (EitangoListItem) getItem(position);

		// �{�^��
		Button btn1;
		Button btn2;

		// convertView�쐬
		if (convertView == null) {
			convertView = mLayoutInflater.inflate(R.layout.row_listview_eitango,null);
		} else {

		}

		// ���X�g�\���̐؂�ւ�
		if (getItemViewType(position) == EitangoListItem.ROW_LAYOUT_STYLY_ENG) {
			// �p��
			TextView tv2 = (TextView) convertView.findViewById(R.id.text_listrow_2);
			tv2.setText(item.getEnglish());
		} else {
			// ���{��
			TextView tv = (TextView) convertView.findViewById(R.id.text_listrow_1);
			tv.setText(item.getWordClass1());

			TextView tv2 = (TextView) convertView.findViewById(R.id.text_listrow_2);
			tv2.setText(item.getJapanese1());

			TextView tv3 = (TextView) convertView.findViewById(R.id.text_listrow_3);
			tv3.setText(item.getWordClass2());

			TextView tv4 = (TextView) convertView.findViewById(R.id.text_listrow_4);
			tv4.setText(item.getJapanese2());


		}

		// �{�^������

		// �u�o�����v�{�^��
		btn1 = (Button) convertView.findViewById(R.id.button_listrow_1);

		// �u�m���Ă��v�{�^��
		btn2 = (Button) convertView.findViewById(R.id.button_listrow_2);

		// �w�K�󋵂ł̃{�^���\���ؑ�
		if(item.getStudyStatus() == EitangoKbnConstant.DONE_STATUS_NOTDONE) {
			btn1.setText("�o�����I");
			btn2.setEnabled(true);
			convertView.setBackgroundColor(Color.WHITE);
		} else {
			btn1.setText("�Y�ꂽ�I");
			btn2.setEnabled(false);
			convertView.setBackgroundColor(Color.GRAY);
		}


		btn1.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {

				EitangoListItem item  = getItem(position);

				// �o�����{�^���������̏���

				// �\�����e�̕ύX�i�F�ύX�A�{�^���ύX�j
				if(item.getStudyStatus() == EitangoKbnConstant.DONE_STATUS_NOTDONE) {
					// �u�o�����I�v����
					// �f�[�^�x�[�X�X�V
					maker.memorizedEitangoItem(item.getDate(), item.getId());

					// �\�����e�X�V
					item.setStudyStatus(EitangoKbnConstant.DONE_STATUS_DONE);
					View vi = (View)v.getParent();
					vi.setBackgroundColor(Color.GRAY);
				} else {
					// �u�Y�ꂽ�I�v����
					// �f�[�^�x�[�X�X�V
					maker.unMemorizedEitangoItem(item.getDate(), item.getId());

					// �\�����e�X�V
					item.setStudyStatus(EitangoKbnConstant.DONE_STATUS_NOTDONE);
					View vi = (View)v.getParent();
					vi.setBackgroundColor(Color.WHITE);
				}
				// �\���ύX�ʒm
				notifyDataSetChanged();
			}
		});

		btn2.setOnClickListener( new OnClickListener() {

			@Override
			public void onClick(View v) {

				EitangoListItem item = (EitangoListItem)v.getTag();
				// �m���Ă��{�^���������̏���

				// �f�[�^�x�[�X�X�V


				// �A�C�e���폜
				EitangoListItem delItem = (EitangoListItem)v.getTag();
				remove(delItem);

				// �\�����e�̕ύX�i�Ď擾�j
				EitangoListItem addItem = maker.changeOneItemList(delItem.getDate(), delItem.getId(), delItem.getDifficulty());
				add(addItem);
//
			}
		});
		return convertView;
	}
}
