package com.student.management.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import com.student.management.objects.Student;

public class FileManagementUtil {

	private static FileInputStream fis;

	private static FileOutputStream fos;

	private static ObjectOutputStream oos;

	private static ObjectInputStream ois;

	private static String STUDENT = "student";

	static {
		File file = new File(STUDENT);

		if (!file.exists()) {
			file.mkdir();
		}
	}

	public static boolean createFile(String file, Student student) {
		Boolean isAvailable = checkFileAvailability(file);
		System.out.println("is Student Available ? " + isAvailable);
		if (!isAvailable){
			createStudentFile(student);
			return true;
		}
		else{
			System.out.println("Student " + student.getIdNumber() + " is already available");
			return false;
		}
	}

	public static Student updateFile(String file, Student student) {
		Boolean isAvailable = checkFileAvailability(file);
		System.out.println("is Student Available ? " + isAvailable);
		if (isAvailable) {
			createStudentFile(student);
			return student;
		} else {
			System.out.println("Student " + student.getIdNumber() + " is not available");
			return student = null;
		}
	}

	public static Student readFile(String file, Student student) {
		Boolean isAvailable = checkFileAvailability(file);
		System.out.println("is Student Available ? " + isAvailable);
		if (isAvailable) {
			return readStudentFile(student);
		} else {
			System.out.println("Student " + student.getIdNumber() + " is not available");
			return student;
		}
	}

	public static List<Student> readFiles() {
		ArrayList<Student> list = new ArrayList<Student>();

		File file = new File(STUDENT);
		if (file.isDirectory()) {
			File[] listFiles = getFilesFromDirectory(file);

			for (File f : listFiles) {
				if (f.isFile()) {
					if (f.getName() != null) {
						System.out.println("Student File : " + f.getName());
						Boolean isAvailable = checkFileAvailability(f.getName());
						System.out.println("is Student Available ? " + isAvailable);
						if (isAvailable) {
							Student student = new Student();
							Student temp = null;
							student.setIdNumber(f.getName());
							temp = readStudentFile(student);
							if (temp != null)
								list.add(temp);
						} else {
							System.out.println("Student is not available");
						}
					}
				}
			}
		}
		return list;
	}
	
	public static boolean deleteFile(Student student) {
		Boolean isAvailable = checkFileAvailability(student.getIdNumber());
		System.out.println("is Student Available ? " + isAvailable);
		if (isAvailable){
			deleletStudentFile(student);
			return true;
		}
		else{
			System.out.println("Student " + student.getIdNumber() + " not available");
			return false;
		}
	}	

	private static String createStudentFile(Student student) {
		try {
			String filePath = createFilePath(student.getIdNumber());
			System.out.println("Creating Student File : " + filePath);

			fos = new FileOutputStream(filePath);

			oos = new ObjectOutputStream(fos);

			oos.writeObject(student);
			System.out.println("Successfully Created Student File : " + student.getIdNumber());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
				oos.flush();
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		return student.getIdNumber();
	}

	private static Student readStudentFile(Student student) {
		Student temp = null;
		try {
			String filePath = createFilePath(student.getIdNumber());
			System.out.println("Reading Student File : " + filePath);

			fis = new FileInputStream(filePath);

			ois = new ObjectInputStream(fis);

			temp = (Student) ois.readObject();

			if (temp != null)
				System.out.println("Successfully Read Student File : " + temp.getIdNumber());
			else
				System.out.println("Failed to Read Student File : " + student.getIdNumber());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return temp;
	}

	private static String deleletStudentFile(Student student) {

		String filePath = createFilePath(student.getIdNumber());

		File file = new File(STUDENT);
		Boolean delete = false;

		if (file.isDirectory()) {
			File[] listFiles = getFilesFromDirectory(file);

			for (File f : listFiles) {
				if (f.isFile()) {
					if (f.getName().equalsIgnoreCase(student.getIdNumber().toString())) {
						System.out.println(f.getAbsolutePath());
						File temp = new File(f.getAbsolutePath());
						delete = temp.delete();
						break;
					}
				}
			}
		}

		System.out.println("Deleting Student File : " + filePath);
		System.out.println("Successfully Deleted Student File ? " + delete + ", " + student.getIdNumber());

		return student.getIdNumber();
	}

	public static File[] getFilesFromDirectory(File file) {
		return file.listFiles();
	}

	private static Boolean checkFileAvailability(String file) {
		Boolean isAvailable = false;
		File f = new File(createFilePath(file));
	
		if (f.exists())
			isAvailable = true;

		return isAvailable;
	}
	
	private static String createFilePath(String file) {
		return STUDENT + File.separator + file;
	}
}