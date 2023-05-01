-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema enjoy_trip
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema enjoy_trip
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `enjoy_trip` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `enjoy_trip` ;

-- -----------------------------------------------------
-- Table `enjoy_trip`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoy_trip`.`user` (
  `user_id` INT NOT NULL AUTO_INCREMENT,
  `user_login_id` VARCHAR(45) NOT NULL,
  `user_password` VARCHAR(45) NOT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `user_email` VARCHAR(45) NOT NULL,
  `user_salt` VARCHAR(45) NOT NULL,
  `user_upload_img_name` VARCHAR(150) NULL DEFAULT NULL,
  `user_store_img_name` VARCHAR(150) NULL DEFAULT NULL,
  `user_is_auth` TINYINT NOT NULL,
  `user_lock_key` VARCHAR(45) NULL DEFAULT NULL,
  `user_mismatch_cnt` INT NULL DEFAULT NULL,
  `user_nickname` VARCHAR(45) NOT NULL,
  `user_auth_key` VARCHAR(45) NULL DEFAULT NULL,
  `user_is_lock` TINYINT NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoy_trip`.`travel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoy_trip`.`travel` (
  `travel_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL DEFAULT NULL,
  `travel_content` BLOB NOT NULL,
  `travel_start_date` TIMESTAMP NOT NULL,
  `travel_end_date` TIMESTAMP NOT NULL,
  `travel_cost` INT NOT NULL,
  `travel_created_date` TIMESTAMP NOT NULL,
  `travel_title` VARCHAR(45) NOT NULL,
  `travel_state` VARCHAR(100) NOT NULL,
  `travel_city` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`travel_id`),
  INDEX `fk_travel_to_user_user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_travel_to_user_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoy_trip`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoy_trip`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoy_trip`.`comment` (
  `comment_id` INT NOT NULL AUTO_INCREMENT,
  `travel_id` INT NULL DEFAULT NULL,
  `comment_order` INT NOT NULL,
  `comment_content` VARCHAR(200) NOT NULL,
  `user_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`comment_id`),
  INDEX `fk_comment_to_record_record_id_idx` (`travel_id` ASC) VISIBLE,
  INDEX `fk_comment_to_user_user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_comment_to_travel_travel_id`
    FOREIGN KEY (`travel_id`)
    REFERENCES `enjoy_trip`.`travel` (`travel_id`),
  CONSTRAINT `fk_comment_to_user_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoy_trip`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoy_trip`.`follow`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoy_trip`.`follow` (
  `follow_id` INT NOT NULL AUTO_INCREMENT,
  `user_id_to` INT NULL DEFAULT NULL,
  `user_id_from` INT NULL DEFAULT NULL,
  `follow_is_follow` TINYINT NULL,
  PRIMARY KEY (`follow_id`),
  INDEX `fk_to_to_user_user_id_idx` (`user_id_to` ASC) VISIBLE,
  CONSTRAINT `fk_to_to_user_user_id`
    FOREIGN KEY (`user_id_to`)
    REFERENCES `enjoy_trip`.`user` (`user_id`),
  CONSTRAINT `fk_from_to_user_user_id`
    FOREIGN KEY (`user_id_from`)
    REFERENCES `enjoy_trip`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoy_trip`.`pin`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoy_trip`.`pin` (
  `pin_id` INT NOT NULL AUTO_INCREMENT,
  `pin_place_name` VARCHAR(100) NOT NULL,
  `pin_place_url` VARCHAR(100) NOT NULL,
  `pin_category_name` VARCHAR(100) NOT NULL,
  `pin_address_name` VARCHAR(100) NOT NULL,
  `pin_road_address_name` VARCHAR(100) NULL DEFAULT NULL,
  `pin_phone` VARCHAR(45) NULL DEFAULT NULL,
  `pin_category_group_code` VARCHAR(45) NULL DEFAULT NULL,
  `pin_category_group_name` VARCHAR(100) NULL DEFAULT NULL,
  `pin_x` DECIMAL(10,0) NOT NULL,
  `pin_y` DECIMAL(10,0) NOT NULL,
  `travel_id` INT NULL DEFAULT NULL,
  `pin_content` VARCHAR(500) NULL DEFAULT NULL,
  PRIMARY KEY (`pin_id`),
  INDEX `fk_pin_to_record_record_id_idx` (`travel_id` ASC) VISIBLE,
  CONSTRAINT `fk_pin_to_travel_travel_id`
    FOREIGN KEY (`travel_id`)
    REFERENCES `enjoy_trip`.`travel` (`travel_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoy_trip`.`image`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoy_trip`.`image` (
  `image_id` INT NOT NULL AUTO_INCREMENT,
  `pin_id` INT NULL DEFAULT NULL,
  `image_upload_name` VARCHAR(150) NOT NULL,
  `image_store_name` VARCHAR(150) NOT NULL,
  `image_is_thumbnail` TINYINT NOT NULL,
  PRIMARY KEY (`image_id`),
  INDEX `fk_image_to_pin_pin_id_idx` (`pin_id` ASC) VISIBLE,
  CONSTRAINT `fk_image_to_pin_pin_id`
    FOREIGN KEY (`pin_id`)
    REFERENCES `enjoy_trip`.`pin` (`pin_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoy_trip`.`plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoy_trip`.`plan` (
  `plan_id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NULL DEFAULT NULL,
  `plan_title` VARCHAR(45) NOT NULL,
  `plan_start_date` TIMESTAMP NOT NULL,
  `plan_end_date` TIMESTAMP NOT NULL,
  PRIMARY KEY (`plan_id`),
  INDEX `fk_plan_to_user_user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_plan_to_user_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoy_trip`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoy_trip`.`route`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoy_trip`.`route` (
  `route_id` INT NOT NULL AUTO_INCREMENT,
  `plan_id` INT NULL DEFAULT NULL,
  `route_place_name` VARCHAR(100) NOT NULL,
  `route_place_url` VARCHAR(100) NOT NULL,
  `route_categor_name` VARCHAR(100) NOT NULL,
  `route_address_name` VARCHAR(100) NOT NULL,
  `route_road_address_name` VARCHAR(100) NULL DEFAULT NULL,
  `route_phone` VARCHAR(45) NULL DEFAULT NULL,
  `route_category_group_code` VARCHAR(45) NULL DEFAULT NULL,
  `route_category_group_name` VARCHAR(100) NULL DEFAULT NULL,
  `route_x` DECIMAL(10,0) NOT NULL,
  `route_y` DECIMAL(10,0) NOT NULL,
  `route_order` INT NOT NULL,
  PRIMARY KEY (`route_id`),
  INDEX `fk_route_to_plan_plan_id_idx` (`plan_id` ASC) VISIBLE,
  CONSTRAINT `fk_route_to_plan_plan_id`
    FOREIGN KEY (`plan_id`)
    REFERENCES `enjoy_trip`.`plan` (`plan_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `enjoy_trip`.`zzim`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `enjoy_trip`.`zzim` (
  `zzim_id` INT NOT NULL AUTO_INCREMENT,
  `travel_id` INT NULL DEFAULT NULL,
  `user_id` INT NULL DEFAULT NULL,
  `zzim_is_zzim` TINYINT NULL,
  PRIMARY KEY (`zzim_id`),
  INDEX `fk_zzim_to_record_record_id_idx` (`travel_id` ASC) VISIBLE,
  INDEX `fk_zzim_to_user_user_id_idx` (`user_id` ASC) VISIBLE,
  CONSTRAINT `fk_zzim_to_travel_travel_id`
    FOREIGN KEY (`travel_id`)
    REFERENCES `enjoy_trip`.`travel` (`travel_id`),
  CONSTRAINT `fk_zzim_to_user_user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `enjoy_trip`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
