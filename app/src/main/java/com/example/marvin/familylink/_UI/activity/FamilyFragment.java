package com.example.marvin.familylink._UI.activity;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.marvin.familylink.R;
import com.example.marvin.familylink._UI._Utils.BLog;
import com.example.marvin.familylink._UI.adapter.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;


/**
 * Created by mawenjing on 15/5/18.
 */
public class FamilyFragment extends Fragment {
    private static Context context;
    private static final String URL = "https://familyshare-211bb.firebaseio.com/family";

    public FamilyFragment() {
    }

    public static Fragment newInstance() {
        FamilyFragment familyFragment = new FamilyFragment();
        return familyFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (BLog.logEnable == true) {
            BLog.d("### Task Fragment onCreateView");
        }

        View view = inflater.inflate(R.layout.fragment_family, null);

        context = getActivity();
        initView();

        return view;
    }

    // Do some refresh work
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();

        if (BLog.logEnable == true) {
            BLog.d("###Task Fragment On Resume");
        }
    }

    private void initView() {
        /*reverse*/
        int redActionButtonSize = getResources().getDimensionPixelSize(R.dimen.red_action_button_size);
        int redActionButtonMargin = getResources().getDimensionPixelOffset(R.dimen.action_button_margin+100);
        int redActionButtonContentSize = getResources().getDimensionPixelSize(R.dimen.red_action_button_content_size);
        int redActionButtonContentMargin = getResources().getDimensionPixelSize(R.dimen.red_action_button_content_margin);
        int redActionMenuRadius = getResources().getDimensionPixelSize(R.dimen.red_action_menu_radius);
        int blueSubActionButtonSize = getResources().getDimensionPixelSize(R.dimen.blue_sub_action_button_size);
        int blueSubActionButtonContentMargin = getResources().getDimensionPixelSize(R.dimen.blue_sub_action_button_content_margin);

        // The floating button part
        final ImageView fabIconNew = new ImageView(context);
        fabIconNew.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_important));

        com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.LayoutParams starParams11 = new com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.LayoutParams(redActionButtonSize, redActionButtonSize);
        starParams11.setMargins(redActionButtonMargin,
                redActionButtonMargin,
                redActionButtonMargin,
                redActionButtonMargin);
        fabIconNew.setLayoutParams(starParams11);

        com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.LayoutParams fabIconStarParams11 = new com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton.LayoutParams(redActionButtonContentSize, redActionButtonContentSize);
        fabIconStarParams11.setMargins(redActionButtonContentMargin,
                redActionButtonContentMargin,
                redActionButtonContentMargin,
                redActionButtonContentMargin);

        final FloatingActionButton rightLowerButton = new FloatingActionButton.Builder(context)
                .setContentView(fabIconNew,fabIconStarParams11)
                .setBackgroundDrawable(R.drawable.button_action_red2_selector)
                .setPosition(FloatingActionButton.POSITION_TOP_LEFT)
                .setLayoutParams(starParams11)
                .build();

        SubActionButton.Builder rLSubBuilder = new SubActionButton.Builder(getActivity());
        rLSubBuilder.setBackgroundDrawable(getResources().getDrawable(R.drawable.button_action_blue_selector));
        FrameLayout.LayoutParams blueContentParams11 = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        blueContentParams11.setMargins(blueSubActionButtonContentMargin,
                blueSubActionButtonContentMargin,
                blueSubActionButtonContentMargin,
                blueSubActionButtonContentMargin);
        rLSubBuilder.setLayoutParams(blueContentParams11);
        FrameLayout.LayoutParams blueParams11 = new FrameLayout.LayoutParams(blueSubActionButtonSize, blueSubActionButtonSize);
        rLSubBuilder.setLayoutParams(blueParams11);

        ImageView rlIcon1 = new ImageView(context);
        ImageView rlIcon2 = new ImageView(context);
        ImageView rlIcon3 = new ImageView(context);
        ImageView rlIcon4 = new ImageView(context);
        ImageView rlIcon5 = new ImageView(context);

        rlIcon1.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_camera));
        rlIcon2.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_picture));
        rlIcon3.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_video));
        rlIcon4.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_location_found));
        rlIcon5.setImageDrawable(getResources().getDrawable(R.drawable.ic_action_headphones));

        final FloatingActionMenu rightLowerMenu = new FloatingActionMenu.Builder(getActivity())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon1,blueContentParams11).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon2, blueContentParams11).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon3, blueContentParams11).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon4,blueContentParams11).build())
                .addSubActionView(rLSubBuilder.setContentView(rlIcon5,blueContentParams11).build())
                .setRadius(redActionMenuRadius)
                .setStartAngle(140)
                .setEndAngle(40)
                .attachTo(rightLowerButton)
                .build();

    }





//    private List<Card> initQuestionCard(List<Task> tasks) {
//        List<Card> questionCards = new ArrayList<Card>();
//        if (tasks != null) {
//            for (int i = 0; i < tasks.size(); i++) {
//                final Task task = tasks.get(i);
//
//                JSONObject options = task.msg.getOptions();
//                String sPositive = null, sNegative = null;
//
//                try {
//                    sPositive = options.getString(MessageContent.POSITIVE);
//                    sNegative = options.getString(MessageContent.NEGATIVE);
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//
//                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//                View answerView = inflater.inflate(R.layout.questioncard_button_action, null);
//                TextView btn_positive  = (TextView) answerView.findViewById(R.id.positive_button);
//                btn_positive.setText(sPositive);
//                TextView btn_negative = (TextView) answerView.findViewById(R.id.negative_button);
//                btn_negative.setText(sNegative);
//
//                ArrayList<BaseSupplementalAction> actions = new ArrayList<BaseSupplementalAction>();
//
//                // Set supplemental actions
//                TextSupplementalAction positive = new TextSupplementalAction(context, R.id.positive_button);
//                positive.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
//                    @Override
//                    public void onClick(Card card, View view) {
//                        onButtonClick(task.getObjectId(), card, MessageContent.POSITIVE);
//                    }
//                });
//                actions.add(positive);
//
//                TextSupplementalAction negative = new TextSupplementalAction(context, R.id.negative_button);
//                negative.setOnActionClickListener(new BaseSupplementalAction.OnActionClickListener() {
//                    @Override
//                    public void onClick(Card card, View view) {
//                        onButtonClick(task.getObjectId(), card, MessageContent.NEGATIVE);
//                    }
//                });
//                actions.add(negative);
//
//                String userId = task.sender.getObjectId();
//                Bitmap bitmap = Utils.imageCache.get(userId);
//
//                if (bitmap == null) {
//                    bitmap = fileCache.getUserPhoto(userId);
//                }
//
//                UnrepliedTaskCard card =
//                        UnrepliedTaskCard.with(context)
//                                .setMainTitle(task.getSender().getUsername())
//                                .setSculpture(bitmap)
//                                .setSubTitle(task.msg.title)
//                                .setCreateTime(task.getTime())
//                                .setupSupplementalActions(R.layout.questioncard_button_action, actions)
//                                .build();
//                card.setType(CARDTYPE_1);
//
//                questionCards.add(card);
//            }
//        }
//
//        return questionCards;
//    }
//
//    private void onButtonClick(String taskId, Card card, String btnType) {
//        MessageUtils.completeTask(taskId, btnType);
//
//        dismissAnimation.animateDismiss(card);
//
//    }
//
//    private List<Card> initTaskCard(List<Task> tasks) {
//        List<Card> taskCards = new ArrayList<Card>();
//        if (tasks != null) {
//            for (int i = 0; i < tasks.size(); i++) {
//                Task task = tasks.get(i);
//
//                SentTaskCard taskCard = new SentTaskCard(context);
//                taskCard.setmCreateTime(task.time);
//                taskCard.setmMessage(task.msg.title);
//                taskCard.setmTasks(getTaskAnswers(task));
//                taskCard.setType(CARDTYPE_2);
//                taskCards.add(taskCard);
//            }
//        }
//        return taskCards;
//    }
//
//    private String[] getTaskAnswers (Task task) {
//        String notRespond = " has not responded";
//
//        List<Answer> answers = task.getAnswers();
//        List<AVUser> receivers = task.getReceivers();
//        MessageContent.Message msg = task.getMsg();
//
//        String[] taskAnswers = new String[receivers.size()];
//
//        Map<String, String> answerList = new HashMap<String, String>();
//        for (int i = 0; i < receivers.size(); i++) {
//            answerList.put(receivers.get(i).getUsername(), notRespond);
//        }
//
//        for (int i = 0; i < answers.size(); i++) {
//            try {
//                answerList.put(answers.get(i).getSender().getUsername(), " answered " + msg.getOptions().getString(answers.get(i).getOptions()));
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//        }
//
//        Iterator iterator = answerList.entrySet().iterator();
//        int count = 0;
//        while (iterator.hasNext()) {
//            Map.Entry entry = (Map.Entry) iterator.next();
//
//            String answerString = "";
//            answerString += (String) entry.getKey();
//            answerString += (String) entry.getValue();
//            taskAnswers[count] = answerString;
//            count ++;
//        }
//
//        return taskAnswers;
//    }

//    // Fragment Refresh
//    @Override
//    public void onRefresh() {
//        final Handler mHandler = new Handler();
//        mHandler.post(new Runnable() {
//            @Override
//            public void run() {
//                refresh();
//            }
//        });
//    }

//    // set the action that swipe layout doing right now
//    private void setSwipeLayoutRefresh(boolean value) {
//        if (value == true) {
//            refreshLayout.post(new Runnable() {
//                @Override
//                public void run() {
//                    refreshLayout.setRefreshing(true);
//                }
//            });
//        } else {
//            refreshLayout.post(new Runnable() {
//                @Override
//                public void run() {
//                    refreshLayout.setRefreshing(false);
//                }
//            });
//        }
//    }

//    class GetCardTask extends AsyncTask<Void, Void, Void> {
//        @Override
//        protected Void doInBackground(Void... params) {
//            unrepliedTasks = MessageUtils.getUnrepliedTasks();
//            sentTasks = MessageUtils.getSentTasks();
//            return null;
//        }
//
//        @Override
//        protected void onPostExecute(Void aVoid) {
//            super.onPostExecute(aVoid);
//            setCardsView();
//            setSwipeLayoutRefresh(false);
//
//            fileCache.saveTaskObject(Constants.UNREPLIED_TASK_MEMORY_KEY, unrepliedTasks);
//            fileCache.saveTaskObject(Constants.SENT_TASK_MEMORY_KEY, sentTasks);
//
//            Constants.EDITOR.putBoolean(Constants.USER_FIRST_LOGIN, false);
//            Constants.EDITOR.commit();
//        }
//    }
//
//    public void setCardsView() {
//        allCards.clear();
//
//        if (unrepliedTasks != null && context != null) {
//            unrepliedCards = initQuestionCard(unrepliedTasks);
//            allCards.addAll(unrepliedCards);
//        }
//        if (sentTasks != null && context != null) {
//            sentCards = initTaskCard(sentTasks);
//            allCards.addAll(sentCards);
//        }
//
//        if (allCards.size() != 0 && allCards != null && context != null) {
//            cardArrayAdapter.notifyDataSetChanged();
//            cardArrayAdapter.setInnerViewTypeCount(CARDTYPE_NUM);
//            dismissAnimation = (SwipeDismissAnimation) new SwipeDismissAnimation(context).
//                    setup(cardArrayAdapter);
//            cardList.setAdapter(cardArrayAdapter);
//        }
//    }
//
//
//    @Override
//    public void onStart() {
//        super.onStart();
//        EventBus.getDefault().register(this);
//    }
//
//    @Override
//    public void onStop() {
//        EventBus.getDefault().unregister(this);
//        super.onStop();
//    }
//
//
//    public void onEvent(RefreshTaskEvent event) {
//        refresh();
//    }
//
//    private void refresh() {
//        if (Utils.isNetworkAvailable(context) == true) {
//            new GetCardTask().execute();
//        } else {
//            Utils.showConnectionNADialog(context);
//        }
//    }


}
