-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               11.1.2-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             12.3.0.6589
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping data for table blog.posts: ~2 rows (approximately)
DELETE FROM `posts`;
INSERT INTO `posts` (`published`, `summary`, `author_id`, `created_at`, `id`, `parent_id`, `published_at`, `updated_at`, `meta_title`, `title`, `content`) VALUES
	(b'1', b'1', 1, '2023-11-30 08:40:43.000000', 1, NULL, '2023-11-30 08:40:43.000000', '2023-11-30 08:40:59.000000', 'React', 'Introduce Reactjs', 'React is a free and open-source front-end JavaScript library for building user interfaces based on components. It is maintained by Meta and a community of individual developers and companies. React can be used to develop single-page, mobile, or'),
	(b'1', b'1', 2, '2023-11-30 10:53:10.000000', 2, NULL, '2023-11-30 10:53:20.000000', '2023-11-30 10:53:21.000000', 'Springboot', 'Jpa with spring boot', 'Spring Data JPA focuses on using JPA to store data in a relational database. Its ... By default, Spring Boot enables JPA repository support and looks in the ...'),
	(b'1', b'1', 1, '2023-11-30 09:40:40.891456', 4, NULL, '2023-11-30 09:40:40.891456', '2023-11-30 09:40:40.891456', 'NextJS', 'Learn NextJS With PTH', 'Next.js is an open-source web development framework created by the private company Vercel providing React-based web applications with server-side rendering and static website generation.');

-- Dumping data for table blog.post_comments: ~1 rows (approximately)
DELETE FROM `post_comments`;
INSERT INTO `post_comments` (`published`, `created_at`, `id`, `parent_id`, `post_id`, `published_at`, `user_id`, `title`, `content`) VALUES
	(b'1', '2023-11-30 10:07:16.000000', 1, NULL, 1, '2023-11-30 10:07:23.000000', 2, 'comment', 'Hay quá'),
	(b'1', '2023-11-30 09:41:39.757565', 4, NULL, 2, '2023-11-30 09:41:39.757565', 1, 'comment', 'Hay quá Thoại ơi \r\n         '),
	(b'1', '2023-11-30 09:44:26.211656', 5, 4, 2, '2023-11-30 09:44:26.211656', 2, 'comment', 'có gì đâu bẹn êi\r\n         ');

-- Dumping data for table blog.users: ~4 rows (approximately)
DELETE FROM `users`;
INSERT INTO `users` (`id`, `last_login`, `registered_at`, `email`, `first_name`, `intro`, `last_name`, `middle_name`, `mobile`, `password_hash`, `profile`) VALUES
	(1, '2023-11-28 21:14:44.000000', '2023-11-28 21:14:45.000000', 'phamhieu@gmail.com', 'Pham', 'ok', 'Hieu', 'Trong', '0971754912', '123', 'hoc gioi'),
	(2, '2023-11-28 21:16:11.000000', '2023-11-28 21:16:12.000000', 'tranthoai@gmail.com', 'Tran', 'ok', 'Thoai', 'Trong', '34343', '123', 'hoc  khong gioi'),
	(3, '2023-11-30 14:13:44.000000', '2023-11-30 14:13:44.000000', 'nguyenlong@gmail.com', 'Nguyeb', 'ok', 'Long', 'Thanh', '24324324234', '123', 'hoc sieu gioi'),
	(4, '2023-11-30 14:14:26.000000', '2023-11-30 14:14:26.000000', 'ngocbich@gmail.com', 'Ngoc', 'ok', 'Bich', 'Thi', '01823716231', '123', 'hoc ok');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
