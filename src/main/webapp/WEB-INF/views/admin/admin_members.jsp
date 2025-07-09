<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../common/head.jsp"%>
<style>
    body {
      background-color: #f8f9fa;
    }
    .sidebar {
      min-height: 100vh;
      background-color: #1c1f23;
      color: white;
    }
    .sidebar a {
      color: white;
      text-decoration: none;
    }
    .sidebar .active {
      background-color: #343a40;
    }
    .card-title {
      font-size: 0.95rem;
      font-weight: bold;
    }
  </style>
</head>
<body>
<div class="container-fluid">
  <div class="row">
    <%@ include file="admin_sidebar.jsp"%>

    <!-- 메인 콘텐츠 -->
    <div class="col-md-10 p-4">
      <div class="d-flex justify-content-between align-items-center mb-3 flex-wrap">
        <h2 class="h5">회원 관리</h2>
        <button class="btn btn-danger btn-sm">📕 가이드 확인하기</button>
      </div>

      <div class="card">
        <div class="card-body">
          <div class="d-flex justify-content-between align-items-center mb-3 flex-wrap">
            <h5 class="card-title mb-0">회원 목록</h5>
            <div class="d-flex flex-wrap gap-2">
              <button class="btn btn-primary btn-sm">Add new</button>
              <button class="btn btn-outline-secondary btn-sm">Import members</button>
              <button class="btn btn-outline-secondary btn-sm">Export members (Excel)</button>
              <button class="btn btn-outline-secondary btn-sm">Filter</button>
            </div>
          </div>

          <div class="table-responsive">
            <table class="table table-hover align-middle">
              <thead class="table-light">
              <tr>
                <th>Photo</th>
                <th>Member name</th>
                <th>Mobile</th>
                <th>Email</th>
                <th>Status</th>
                <th>Operation</th>
                <th>Action</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td><img src="https://via.placeholder.com/40" class="rounded-circle" alt="Photo"></td>
                <td>George Lindelof</td>
                <td>+4 315 23 62</td>
                <td>carlsen@armand.no</td>
                <td><span class="badge bg-success">Active</span></td>
                <td>
                  <a href="#" class="me-2 text-decoration-none"><i class="bi bi-box-arrow-up-right"></i></a>
                  <a href="#" class="me-2 text-decoration-none"><i class="bi bi-pencil"></i></a>
                  <a href="#" class="text-decoration-none"><i class="bi bi-trash"></i></a>
                </td>
                <td><button class="btn btn-sm btn-outline-primary">Login</button></td>
              </tr>
              <!-- 반복 데이터가 들어갈 부분 -->
              </tbody>
            </table>
          </div>

          <div class="d-flex justify-content-end mt-2 text-muted small">
            Total members: <strong>2000</strong>, Current used: <strong>1800</strong>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>