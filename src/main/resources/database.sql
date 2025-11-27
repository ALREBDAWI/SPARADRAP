
create database sparadrap_db;
use sparadrap_db;

create table doctors(
                        doctor_id int auto_increment primary key,
                        first_name varchar(100) not null,
                        last_name varchar(100) not null,
                        license_number varchar(15) not null unique,
                        telephone varchar(15),
                        email varchar(100),
                        post_code varchar(10),
                        city varchar(50),
                        address varchar(100)
);

/*french land departments*/
create table departments(
                            department_id int auto_increment primary key,
                            department_name varchar(100),
                            department_number int unique
);

create table categories_med(
                               category_id int auto_increment primary key,
                               category_name varchar(100) not null unique
);

create table insurances(
                           insurance_id int auto_increment primary key,
                           insurance_name varchar(100) not null,
                           city varchar(50),
                           telephone varchar(15),
                           email varchar(100),
                           post_code varchar(10),
                           address varchar(100),
                           department_id int,
                           foreign key (department_id) references departments(department_id) ON DELETE SET NULL
);

create table patients(
                         patient_id int auto_increment primary key,
                         first_name varchar(100) not null,
                         last_name varchar(100) not null,
                         social_sec_number varchar(15) not null unique,
                         birth_date date, /**this to be changed to not null**/
                         telephone varchar(15),
                         email varchar(100),
                         city varchar(50),
                         post_code varchar(10),
                         address varchar(100),
                         insurance_id int,
                         doctor_id int,
                         foreign key (doctor_id) references doctors(doctor_id) ON DELETE SET NULL,
                         foreign key (insurance_id) references insurances(insurance_id) ON DELETE SET NULL
);

create table medicines(
                          medicine_id int auto_increment primary key,
                          medicine_name varchar(100) not null,
                          price DECIMAL(15,2) NOT NULL,
                          deployment_date DATE NOT NULL,
                          quantity INT NOT NULL,
                          is_with_prescription BOOLEAN NOT NULL,
                          category_id int,
                          foreign key (category_id) references categories_med(category_id) ON DELETE SET NULL
);

create table prescriptions(
                              prescription_id int auto_increment primary key,
                              date_prescription date,
                              doctor_id int,
                              patient_id int,
                              foreign key (patient_id) references patients(patient_id) ON DELETE SET NULL,
                              foreign key (doctor_id) references doctors(doctor_id) ON DELETE SET NULL
);


create table purchases(
                          purchase_id int auto_increment primary key,
                          purchase_date date,
                          prescription_id int,
                          foreign key (prescription_id) references prescriptions(prescription_id) ON DELETE SET NULL
);

create table prescription_meds(
                                  prescription_id int,
                                  medicine_id int,
                                  primary key (prescription_id, medicine_id),
                                  foreign key (prescription_id) references prescriptions(prescription_id) ON DELETE CASCADE,
                                  foreign key (medicine_id) references medicines(medicine_id) ON DELETE CASCADE
);

create table purchase_meds(
                              purchase_id int,
                              medicine_id int,
                              PRIMARY KEY (purchase_id, medicine_id),
                              foreign key (purchase_id) references purchases(purchase_id) ON DELETE CASCADE,
                              foreign key (medicine_id) references medicines(medicine_id) ON DELETE CASCADE
);

create table insurance_plans(
                                plan_id int AUTO_INCREMENT PRIMARY KEY,
                                plan_name varchar(50) not null unique,
                                insurance_id int,
                                foreign key (insurance_id) references insurances(insurance_id) ON DELETE CASCADE
);

/********************************* insert data for testing *********************************************/

-- 1. Departments
INSERT INTO departments (department_name, department_number) VALUES
                                                                 ('Paris', 75),
                                                                 ('Lyon', 69);

-- 2. Categories
INSERT INTO categories_med (category_name) VALUES
                                               ('Antibiotics'),
                                               ('Painkillers');

-- 3. Doctors
INSERT INTO doctors (first_name, last_name, license_number, telephone, email, post_code, city, address) VALUES
                                                                                                            ('Jean', 'Dupont', 'LIC12345', '0102030405', 'jean.dupont@example.com', '75001', 'Paris', '10 Rue de Rivoli'),
                                                                                                            ('Marie', 'Durand', 'LIC67890', '0607080910', 'marie.durand@example.com', '69001', 'Lyon', '20 Rue de la Republique');

-- 4. Insurances
INSERT INTO insurances (insurance_name, telephone, email, post_code, address, department_id) VALUES
                                                                                                 ('Assurance Sante Paris', '0145789632', 'contact@assuranceparis.fr', '75001', '15 Avenue des Champs-Elysees', 1),
                                                                                                 ('Assurance Lyon', '0478123456', 'contact@assurancelyon.fr', '69001', '25 Rue de Lyon', 2);

-- 5. Patients
INSERT INTO patients (first_name, last_name, social_sec_number, birth_date, telephone, email, post_code, address, insurance_id, doctor_id) VALUES
                                                                                                                                               ('Pierre', 'Martin', 'SS123456789', '1990-05-12', '0612345678', 'pierre.martin@example.com', '75002', '5 Rue Saint-Honore', 1, 1),
                                                                                                                                               ('Sophie', 'Bernard', 'SS987654321', '1985-09-20', '0678901234', 'sophie.bernard@example.com', '69002', '10 Rue Victor Hugo', 2, 2);

-- 6. Medicines
INSERT INTO medicines (medicine_name, price, deployment_date, quantity, is_with_prescription, category_id) VALUES
                                                                                                               ('Amoxicillin', 12.50, '2024-01-10', 100, true, 1),
                                                                                                               ('Ibuprofen', 5.00, '2024-02-15', 200, false, 2);

-- 7. Prescriptions
INSERT INTO prescriptions (date_prescription, doctor_id, patient_id) VALUES
                                                                         ('2024-03-01', 1, 1),
                                                                         ('2024-03-02', 2, 2);

-- 8. Purchases
INSERT INTO purchases (purchase_date, prescription_id) VALUES
                                                           ('2024-03-03', 1),
                                                           ('2024-03-04', 2);

-- 9. Prescription_Meds
INSERT INTO prescription_meds (prescription_id, medicine_id) VALUES
                                                                 (1, 1),
                                                                 (2, 2);

-- 10. Purchase_Meds
INSERT INTO purchase_meds (purchase_id, medicine_id) VALUES
                                                         (1, 1),
                                                         (2, 2);

-- 11. Insurance_Plans
INSERT INTO insurance_plans (plan_name, insurance_id) VALUES
                                                          ('STANDARD', 1),
                                                          ('PREMIUM', 2);


show tables;
