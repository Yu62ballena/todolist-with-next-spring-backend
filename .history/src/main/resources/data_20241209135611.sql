-- users テーブル
INSERT INTO users(username, email, hashed_password, thumbnail_path) VALUES
('ゆう','sample@sample.com','password',sample.jpg")
ON 
  user_uuid UUID;
BEGIN
  SELECT user_id INTO user_uuid FROM users WHERE email = 'sample@sample.com';

-- tasks テーブル
INSERT INTO tasks(task_id, user_id, task_name, is_complete, due_date) VALUES
(1, user_uuid, "牛乳を買う", false, null),
(2, user_uuid, "病院の予約をする", true, null),
(3, user_uuid, "プログラムの勉強をする", false, null),
(4, user_uuid, "掃除をする", false, null),
(5, user_uuid, "牛乳を飲む", true, null),
(6, user_uuid, "プログラムの本を見る", true, null);
ON CONFLICT DO NOTHING;
END $$;
